package com.android.elea.activities.messages;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.elea.R;
import com.android.elea.activities.JobDetailsActivity;
import com.android.elea.activities.JobViewActivity;
import com.android.elea.activities.MainMenuActivity;
import com.android.elea.activities.SearchResultListActivity;
import com.android.elea.activities.account.UserProfileActivity;
import com.android.elea.beans.Job;
import com.android.elea.beans.Message;
import com.android.elea.business.MessageBS;
import com.android.elea.utils.CacheManager;
import com.android.elea.utils.ConfirmDialog;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.NumericConstants;
import com.android.elea.utils.SessionManager;
import com.android.elea.utils.TextConstants;

import java.util.Date;

public class NewMessageActivity extends Activity {

    private SessionManager session;

    private Job job;
    private String operation;

    private TextView newMessageMainTitle;
//    private TextView newMessagesSubjectText;
//    private TextView newMessagesMessageText;

    private EditText newMessagesSubjectValue;
    private EditText newMessagesMessageValue;

    private Button btnSendNewMessage;
//    private Button btnNewMessageCancel;

    private ImageView newMessageJobDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_message);

            Bundle bundle = this.getIntent().getExtras();
            operation = bundle.getString(TextConstants.BUNDLE_PARAMETER_OPERATION);
            job = bundle.getParcelable(TextConstants.BUNDLE_PARAMETER_JOB);

            session = new SessionManager(getApplicationContext());
            initListeners();
            fillDefaultText();
        }catch (Exception e){
            new EleaException(e);
        }
    }

    private void initListeners(){
        try{

            newMessageMainTitle = (TextView) findViewById(R.id.newMessageMainTitle);
//            newMessagesSubjectText = (TextView) findViewById(R.id.newMessagesSubjectText);
//            newMessagesMessageText = (TextView) findViewById(R.id.newMessagesMessageText);

            newMessagesSubjectValue = (EditText) findViewById(R.id.newMessagesSubjectValue);
            newMessagesMessageValue = (EditText) findViewById(R.id.newMessagesMessageValue);

            btnSendNewMessage = (Button) findViewById(R.id.btnSendNewMessage);
//            btnNewMessageCancel = (Button) findViewById(R.id.btnNewMessageCancel);

            newMessageJobDetails = (ImageView) findViewById(R.id.newMessageJobDetails);

            btnSendNewMessage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        if (checkSendMailValues())
                            sendNewMessage();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

            newMessageJobDetails.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    try {
                        showJobDetails();
                    } catch (Exception e) {
                        new EleaException(e);
                    }
                }
            });

        }catch (Exception e){
            new EleaException(e);
        }
    }

    private void fillDefaultText(){
        try {

            newMessageMainTitle.setText(getResources().getString(R.string.my_messages_new_message_header));

            StringBuilder subject = new StringBuilder();
            StringBuilder message = new StringBuilder();

            if(job.isOffer()){
                message.append(getResources().getString(R.string.my_messages_new_message_default_text_offer));
                message.append(job.getTitle());
            }else{
                message.append(getResources().getString(R.string.my_messages_new_message_default_text_demand));
                message.append(job.getTitle());
            }

            newMessagesMessageValue.setText(message.toString());

        }catch (Exception e){
            new EleaException(e);
        }
    }

    private void sendNewMessage(){
        try{

            //guardamos el mensaje en base de datos
            Message newMessage = new Message();

            newMessage.setJob(job);
            newMessage.setSubject(newMessagesSubjectValue.getText().toString());
            newMessage.setMessageText(newMessagesMessageValue.getText().toString());
            newMessage.setSender(CacheManager.getUser());
            newMessage.setReceiver(job.getUser());
            newMessage.setDateCreated(new Date());
            newMessage.setIsRead(Boolean.FALSE);

            MessageBS.insertMessage(this,newMessage);

            //TODO: enviar mail o notificacion
            //es necesario un intent que levante la actividad deseada
//            Intent itSend = new Intent(android.content.Intent.ACTION_SEND);

//            //vamos a enviar texto plano a menos que el checkbox este marcado
//            itSend.setType("plain/text");
//
//            //colocamos los datos para el envio
//            itSend.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ "borjasancholopez@gmail.com"});
//            itSend.putExtra(android.content.Intent.EXTRA_SUBJECT, newMessagesSubjectValue.getText().toString());
//            itSend.putExtra(android.content.Intent.EXTRA_TEXT, newMessagesMessageValue.getText());

            //revisamos si el checkbox esta marcado enviamos el icono de la aplicacion como adjunto
    //        if (chkAttachment.isChecked()) {
    //            //colocamos el adjunto en el stream
    //            itSend.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.icon));
    //
    //            //indicamos el tipo de dato
    //            itSend.setType("image/png");
    //        }

            //iniciamos la actividad
//            startActivity(itSend);
        }catch (Exception e){
            new EleaException(e);
        }
    }

//    private void cancel(){
//
//    }

    private boolean checkSendMailValues(){

        //checkeamos que exista el asunto y que no supere el tamano maximo
        if(newMessagesSubjectValue.getText().toString().trim().length() == 0){
            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.my_messages_error_title), getResources().getString(R.string.my_messages_error_no_subject),-1);
            newFragment.show(getFragmentManager(),"job_error_no_title");
            return false;
        }else if(newMessagesSubjectValue.getText().toString().trim().length() > 100){
            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.my_messages_error_title), getResources().getString(R.string.my_messages_error_max_subject),-1);
            newFragment.show(getFragmentManager(),"job_error_max_title");
            return false;
        }
        //checkeamos que exista el mensaje y que no supere el tamano maximo
        else if(newMessagesMessageValue.getText().toString().trim().length() == 0){
            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.my_messages_error_title), getResources().getString(R.string.my_messages_error_no_message),-1);
            newFragment.show(getFragmentManager(),"job_error_no_title");
            return false;
        }else if(newMessagesMessageValue.getText().toString().trim().length() > 4000){
            DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.my_messages_error_title), getResources().getString(R.string.my_messages_error_max_message),-1);
            newFragment.show(getFragmentManager(),"job_error_max_description");
            return false;
        }

        return true;
    }

    private void showJobDetails(){
        try{
            Intent intent = new Intent(NewMessageActivity.this,JobViewActivity.class);

            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_VIEW_JOB);
            b.putParcelable(TextConstants.BUNDLE_PARAMETER_JOB, job);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    ////////////////////////////////////////////////////////    MENU SUPERIOR    ////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_job_details, menu);

        if(!session.isLoggedIn()) {
            MenuItem item = menu.findItem(R.id.upperMenuLogout);
            item.setVisible(false);
            this.invalidateOptionsMenu();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        try {
            int id = item.getItemId();

            if (id == R.id.upperMenuNewJob) {
                jobDetails(TextConstants.OPERATION_NEW_JOB);
            }else if (id == R.id.upperMenuFavorites) {
                favorites();
            }else if (id == R.id.upperMenuMyJobs) {
                myJobs();
            }else if (id == R.id.upperMenuMyProfile) {
                myProfile();
            }else if(id == R.id.upperMenuLogout) {
                logoutUpperMenu();
            }else if(id == R.id.upperMenuExit) {
                exitUpperMenu();
            }else if(id == R.id.upperMenuSearch) {
                upperMenuSearch();
            }else if (id == R.id.upperMenuMyMessages) {
                myMessages();
            }
        } catch (Exception e) {
            new EleaException(e);
        }

        return super.onOptionsItemSelected(item);
    }

    private void myMessages(){
        try {
            Intent intent = new Intent(this, MessagesMenuActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void logoutUpperMenu(){
        DialogFragment newFragment = ConfirmDialog.newInstance(getResources().getString(R.string.logout_title), getResources().getString(R.string.logout_text), NumericConstants.LOGOUT_FRAGMENT_ID);
        newFragment.show(getFragmentManager(), "logoutConfirmacion");
    }

    private void exitUpperMenu(){
        DialogFragment newFragment = ConfirmDialog.newInstance(getResources().getString(R.string.exit_app_title),getResources().getString(R.string.exit_app_text), NumericConstants.EXIT_APP_FRAGMENT_ID);
        newFragment.show(getFragmentManager(), "exitAppConfirmacion");
    }

    private void myProfile(){
        try {
            Intent intent = new Intent(this, UserProfileActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void myJobs(){
        try {
            Intent intent = new Intent(this, SearchResultListActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION, TextConstants.OPERATION_MY_JOBS);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void favorites(){
        try {
            Intent intent = new Intent(this, SearchResultListActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_FAVORITES);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void jobDetails(String operation){
        try {
            //Creamos el Intent
            Intent intent = new Intent(this, JobDetailsActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,operation);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void upperMenuSearch(){
        startActivity(new Intent(this, MainMenuActivity.class));
    }

}
