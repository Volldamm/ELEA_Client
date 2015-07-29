package com.android.elea.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.elea.R;
import com.android.elea.activities.account.UserProfileActivity;
import com.android.elea.activities.messages.MessagesMenuActivity;
import com.android.elea.adapters.SearchResultListAdapter;
import com.android.elea.beans.Job;
import com.android.elea.beans.Province;
import com.android.elea.beans.Town;
import com.android.elea.business.JobBS;
import com.android.elea.db.SearchFilters;
import com.android.elea.utils.CacheManager;
import com.android.elea.utils.ConfirmDialog;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.NumericConstants;
import com.android.elea.utils.SessionManager;
import com.android.elea.utils.TextConstants;
import com.android.elea.utils.Utils;

import java.util.List;

public class SearchResultListActivity extends Activity {


    private String searchText;
    private Province province;
    private Town town;

    private ListView searchResultList;
    private Job selectedJob;
    private String operation;
    private boolean isOffer;

    private SearchResultListAdapter adapter;

    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_search_result_list);

            session = new SessionManager(getApplicationContext());

            //Recuperamos la información pasada en el intent
            Bundle bundle = this.getIntent().getExtras();

            //primero recuperamos el parametro operation, que será el que nos indique el camino a seguir y el resto de parametros que debemos recuperar
            operation =  bundle.getString(TextConstants.BUNDLE_PARAMETER_OPERATION);

            ///////////////////////////     BUSQUEDA PRINCIPAL
            if(operation.compareTo(TextConstants.OPERATION_MAIN_SEARCH)==0){

                getActionBar().setTitle(getResources().getString(R.string.result_list_header_text_results));

                isOffer = bundle.getBoolean(TextConstants.BUNDLE_PARAMETER_IS_OFFER);
                searchText = bundle.getString(TextConstants.BUNDLE_PARAMETER_SEARCH_TEXT);
                province = bundle.getParcelable(TextConstants.BUNDLE_PARAMETER_PROVINCE);
                town = bundle.getParcelable(TextConstants.BUNDLE_PARAMETER_TOWN);

                SearchFilters filters = new SearchFilters();
                filters.setCountry(CacheManager.getDefaultCountry());
                filters.setProvince(province);
                filters.setTown(town);
                filters.setOffer(isOffer);
                filters.setText(searchText);

                List<Job> resultList = JobBS.searchJobsByCriteria(getApplicationContext(), filters);
                if(resultList != null && resultList.size()>0) {
                    prepareJobList(resultList);
                    createList(resultList);
                    initListeners();
                }else{
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.result_list_header_text_searching), getResources().getString(R.string.result_list_no_results),NumericConstants.NO_RESULTS_FRAGMENT_ID);
                    newFragment.show(getFragmentManager(),"noResultsFragment");
                }
            }
            ///////////////////////////     FAVORITOS
            else if(operation.compareTo(TextConstants.OPERATION_FAVORITES)==0){
                getActionBar().setTitle(getResources().getString(R.string.result_list_header_text_favorites));

                SearchFilters filters = new SearchFilters();
                filters.setCountry(CacheManager.getDefaultCountry());
                filters.setIsFavorite(true);

                List<Job> resultList = JobBS.searchJobsByCriteria(getApplicationContext(), filters);
                if(resultList != null && resultList.size()>0) {
                    prepareJobList(resultList);
                    createList(resultList);
                    initListeners();
                }else{
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.result_list_header_text_favorites), getResources().getString(R.string.result_list_no_results),NumericConstants.NO_RESULTS_FRAGMENT_ID);
                    newFragment.show(getFragmentManager(),"noResultsFragment");
                }
            }
            ///////////////////////////     MIS ANUNCIOS
            else if(operation.compareTo(TextConstants.OPERATION_MY_JOBS)==0){

                getActionBar().setTitle(getResources().getString(R.string.result_list_header_text_my_jobs));

                List<Job> resultList = JobBS.searchJobsByUser(getApplicationContext(), CacheManager.getUser());
                if(resultList != null && resultList.size()>0) {
                    prepareJobList(resultList);
                    createList(resultList);
                    initListeners();
                }else{
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.result_list_header_text_my_jobs), getResources().getString(R.string.result_list_no_my_jobs),NumericConstants.NO_RESULTS_FRAGMENT_ID);
                    newFragment.show(getFragmentManager(), "noResultsFragment");

                }
            }
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    public void goToMainMenu(){
        startActivity(new Intent(SearchResultListActivity.this, MainMenuActivity.class));
    }

    private void prepareJobList(List<Job> jobList){
        StringBuilder subTitle;
        try {
            for(Job job:jobList){
                subTitle = new StringBuilder();
                if(job.getTown() != null && job.getTown().getName() != null && job.getTown().getName().trim().length()>0){
                    subTitle.append(job.getTown().getName());
                    subTitle.append(TextConstants.COMMA);
                    subTitle.append(TextConstants.WHITE_SPACE);
                }
                if(job.getProvince() != null && job.getProvince().getName() != null && job.getProvince().getName().trim().length()>0){
                    subTitle.append(job.getProvince().getName());
                    subTitle.append(TextConstants.COMMA);
                    subTitle.append(TextConstants.WHITE_SPACE);
                }

                if(job.getPaymentMode() != null){
                    if(job.getPaymentMode().compareTo("H")==0){
                        subTitle.append(job.getAmount());
                        subTitle.append(getResources().getString(R.string.common_currency));
                        subTitle.append(TextConstants.SLASH);
                        subTitle.append(getResources().getString(R.string.job_details_payment_mode_H_text));
                    }
                    if(job.getPaymentMode().compareTo("D")==0){
                        subTitle.append(job.getAmount());
                        subTitle.append(getResources().getString(R.string.common_currency));
                        subTitle.append(TextConstants.SLASH);
                        subTitle.append(getResources().getString(R.string.job_details_payment_mode_D_text));
                    }
                    if(job.getPaymentMode().compareTo("J")==0){
                        subTitle.append(job.getAmount());
                        subTitle.append(getResources().getString(R.string.common_currency));
                        subTitle.append(TextConstants.SLASH);
                        subTitle.append(getResources().getString(R.string.job_details_payment_mode_J_text));
                    }
                    if(job.getPaymentMode().compareTo("C")==0){//los trabajos a convenir no tienen cantidad
                        subTitle.append(getResources().getString(R.string.job_details_payment_mode_C_text));
                    }
                }
                job.setSubtitle(subTitle.toString());
                job.setSinceWhen(Utils.calculateSinceWhen(job.getDateCreated()));
            }
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void initListeners(){

        try {
            searchResultList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    selectedJob = (Job) a.getItemAtPosition(position);
                    showJobDetails();
//                    ///////////////////////////     BUSQUEDA PRINCIPAL
//                    if (operation.compareTo(TextConstants.OPERATION_MAIN_SEARCH) == 0) {
//                        showJobDetails();
//                    }
//                    ///////////////////////////     FAVORITOS
//                    else if (operation.compareTo(TextConstants.OPERATION_FAVORITES) == 0) {
//                        showJobDetails();
//                    }
//                    ///////////////////////////     MIS ANUNCIOS
//                    else if (operation.compareTo(TextConstants.OPERATION_MY_JOBS) == 0) {
//                        editJobDetails();
//                    }
//
//                    Utils.showToast(getApplicationContext(), "Lista: " + selectedJob.getTitle());
                }
            });
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void showJobDetails(){
        try{
            Intent intent = new Intent(SearchResultListActivity.this,JobViewActivity.class);

            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_VIEW_JOB);
            b.putParcelable(TextConstants.BUNDLE_PARAMETER_JOB, selectedJob);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

//    private void editJobDetails(){
//        try{
//
//        } catch (Exception e) {
//            new EleaException(e);
//        }
//    }

    private void createList(List<Job> resultList){
        try {
            adapter = new SearchResultListAdapter(this, this ,resultList,operation,session.isLoggedIn());

            searchResultList = (ListView)findViewById(R.id.searchResultList);
            searchResultList.setAdapter(adapter);

            //creamos la cabecera
            View header = getLayoutInflater().inflate(R.layout.search_result_list_header, null);
            TextView headerText = (TextView) header.findViewById(R.id.searchResultHeader);
            TextView subHeaderText = (TextView) header.findViewById(R.id.searchResultSubHeader);

            if(operation.compareTo(TextConstants.OPERATION_MAIN_SEARCH)==0){
                headerText.setText(getResources().getString(R.string.result_list_header_text_searching));
                subHeaderText.setText(createSubHeader());

            }
            else if(operation.compareTo(TextConstants.OPERATION_FAVORITES)==0){
                headerText.setVisibility(View.GONE);//.setText(getResources().getString(R.string.result_list_header_text_favorites));
                subHeaderText.setVisibility(View.GONE);

            }
            else if(operation.compareTo(TextConstants.OPERATION_MY_JOBS)==0){
                headerText.setVisibility(View.GONE);//.setText(getResources().getString(R.string.result_list_header_text_my_jobs));
                subHeaderText.setVisibility(View.GONE);

            }

            searchResultList.addHeaderView(header);

        } catch (Resources.NotFoundException e) {
            new EleaException(e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        try {
            getMenuInflater().inflate(R.menu.menu_search_result_list, menu);

            //ocultamos los items del menu superior segun la operacion
            if(operation.compareTo(TextConstants.OPERATION_MAIN_SEARCH)==0){

            }
            else if(operation.compareTo(TextConstants.OPERATION_FAVORITES)==0){
                MenuItem item = menu.findItem(R.id.upperMenuFavorites);
                item.setVisible(false);
                this.invalidateOptionsMenu();
            }
            else if(operation.compareTo(TextConstants.OPERATION_MY_JOBS)==0){
                MenuItem item = menu.findItem(R.id.upperMenuMyJobs);
                item.setVisible(false);
                this.invalidateOptionsMenu();
            }

            if(!session.isLoggedIn()) {
                MenuItem item = menu.findItem(R.id.upperMenuLogout);
                item.setVisible(false);
                this.invalidateOptionsMenu();
            }

        } catch (Exception e) {
            new EleaException(e);
        }
        return true;
    }

    private String createSubHeader(){
        StringBuilder subHeader = new StringBuilder();
        StringBuilder subHeaderTown = new StringBuilder();

        try {
            if(searchText != null && searchText.trim().length()>0){
                subHeader.append(searchText);
            }

            if(subHeader.length()>0){
                subHeader.append(TextConstants.WHITE_SPACE);
            }

            if(province != null && province.getName() !=null && province.getName().trim().length()>0){
                subHeaderTown.append(province.getName());
            }

            if(town != null && town.getName() !=null && town.getName().trim().length()>0){
                if(subHeaderTown.length()>0){
                    subHeaderTown.append(TextConstants.COMMA);
                    subHeaderTown.append(TextConstants.WHITE_SPACE);
                }
                subHeaderTown.append(town.getName());
            }

            if(subHeaderTown.length()>0){
                subHeader.append(getResources().getString(R.string.common_text_in));
                subHeader.append(TextConstants.WHITE_SPACE);
                subHeader.append(subHeaderTown.toString());
            }
            subHeader.append(TextConstants.ENTER);
        } catch (Resources.NotFoundException e) {
            new EleaException(e);
        }
        return subHeader.toString();
    }


    ////////////////////////////////////////////////////////    MENU SUPERIOR    ////////////////////////////////////////////////////////
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        try {
            int id = item.getItemId();

            if (id == R.id.upperMenuNewJob) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    jobDetails(TextConstants.OPERATION_NEW_JOB);
            }else if (id == R.id.upperMenuFavorites) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    favorites();
            }else if (id == R.id.upperMenuMyJobs) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    myJobs();
            }else if (id == R.id.upperMenuMyProfile) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    myProfile();
            }else if(id == R.id.upperMenuLogout) {
                logoutUpperMenu();
            }else if(id == R.id.upperMenuExit) {
                exitUpperMenu();
            }else if(id == R.id.upperMenuSearch) {
                upperMenuSearch();
            }else if (id == R.id.upperMenuMyMessages) {
                if(!session.isLoggedIn()) {
                    DialogFragment newFragment = MessageDialog.newInstance(getResources().getString(R.string.common_text_error), getResources().getString(R.string.upper_menu_login_error),-1);
                    newFragment.show(getFragmentManager(), "errorLogin");
                }else
                    myMessages();
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return super.onOptionsItemSelected(item);
    }

    private void myMessages(){
        try {
            Intent intent = new Intent(SearchResultListActivity.this, MessagesMenuActivity.class);
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
            Intent intent = new Intent(SearchResultListActivity.this, UserProfileActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void myJobs(){
        try {
            Intent intent = new Intent(SearchResultListActivity.this, SearchResultListActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_MY_JOBS);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void favorites(){
        try {
            Intent intent = new Intent(SearchResultListActivity.this, SearchResultListActivity.class);
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
            Intent intent = new Intent(SearchResultListActivity.this, JobDetailsActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,operation);
            intent.putExtras(b);
            startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }
    private void upperMenuSearch(){
        startActivity(new Intent(SearchResultListActivity.this, MainMenuActivity.class));
    }

    public SearchResultListAdapter getAdapter() {
        return adapter;
    }

}
