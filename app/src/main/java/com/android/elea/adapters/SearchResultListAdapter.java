package com.android.elea.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.elea.R;
import com.android.elea.activities.JobDetailsActivity;
import com.android.elea.activities.MainMenuActivity;
import com.android.elea.activities.SearchResultListActivity;
import com.android.elea.activities.messages.NewMessageActivity;
import com.android.elea.beans.Job;
import com.android.elea.business.FavoriteBS;
import com.android.elea.business.JobBS;
import com.android.elea.utils.ConfirmDialog;
import com.android.elea.utils.EleaException;
import com.android.elea.utils.MessageDialog;
import com.android.elea.utils.NumericConstants;
import com.android.elea.utils.TextConstants;
import com.android.elea.utils.Utils;

import java.util.List;

/**
 * Created by Borja on 30/04/2015.
 */
public class SearchResultListAdapter extends ArrayAdapter<Job> {


    private static List<Job> resultList;
    private static Context context;
    private String operation;
    private SearchResultListActivity activity;
    private Job selectedJob;
    private static boolean isLoggedIn;

    public SearchResultListAdapter(Context context, SearchResultListActivity activity, List<Job> resultList,String operation, boolean isLoggedIn) {
        super(context, R.layout.activity_search_result_list, resultList);
        try {

            this.context = context;
            this.resultList = resultList;
            this.operation = operation;
            this.activity = activity;
            this.isLoggedIn = isLoggedIn;
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View item = convertView;
        final ViewHolder holder;

        try {
            if(item == null)
            {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                item = inflater.inflate(R.layout.search_result_list_item, null);

                holder = new ViewHolder();

                holder.title = (TextView)item.findViewById(R.id.searchResultTitle);
                holder.subTitle = (TextView)item.findViewById(R.id.searchResultSubTitle);
                holder.sinceWhen = (TextView)item.findViewById(R.id.searchResultSinceWhen);
                holder.starIcon = (CheckBox)item.findViewById(R.id.searchResultStar);
                holder.emailIcon = (ImageView)item.findViewById(R.id.searchResultEmail);
                holder.deleteIcon = (ImageView)item.findViewById(R.id.searchResultDelete);
                holder.editIcon = (ImageView)item.findViewById(R.id.searchResultEdit);

                holder.deleteIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!isLoggedIn) {
                            DialogFragment newFragment = MessageDialog.newInstance(context.getResources().getString(R.string.common_text_error), context.getResources().getString(R.string.upper_menu_login_error),-1);
                            newFragment.show(activity.getFragmentManager(), "errorLogin");
                        }else
                            deleteAction(position);
                    }
                });

                holder.editIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!isLoggedIn) {
                            DialogFragment newFragment = MessageDialog.newInstance(context.getResources().getString(R.string.common_text_error), context.getResources().getString(R.string.upper_menu_login_error),-1);
                            newFragment.show(activity.getFragmentManager(), "errorLogin");
                        }else
                            editAction(position);
                    }
                });
                
                holder.starIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!isLoggedIn) {
                            DialogFragment newFragment = MessageDialog.newInstance(context.getResources().getString(R.string.common_text_error), context.getResources().getString(R.string.upper_menu_login_error),-1);
                            newFragment.show(activity.getFragmentManager(), "errorLogin");
                        }else
                            starAction(position);
                    }
                });

                holder.emailIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!isLoggedIn) {
                            DialogFragment newFragment = MessageDialog.newInstance(context.getResources().getString(R.string.common_text_error), context.getResources().getString(R.string.upper_menu_login_error),-1);
                            newFragment.show(activity.getFragmentManager(), "errorLogin");
                        }else
                            emailAction(position);
                    }
                });
                item.setTag(holder);

            }else{
                holder = (ViewHolder)item.getTag();
            }

            holder.title.setText(resultList.get(position).getTitle());
            holder.subTitle.setText(resultList.get(position).getSubtitle());
            holder.sinceWhen.setText(resultList.get(position).getSinceWhen());
            holder.starIcon.setChecked(resultList.get(position).getIsFavourite());

            ///////////////////////////     BUSQUEDA PRINCIPAL
            if(operation.compareTo(TextConstants.OPERATION_MAIN_SEARCH)==0){
                holder.editIcon.setVisibility(View.GONE);
                holder.deleteIcon.setVisibility(View.GONE);
            }
            ///////////////////////////     FAVORITOS
            else if(operation.compareTo(TextConstants.OPERATION_FAVORITES)==0){
                holder.editIcon.setVisibility(View.GONE);
                holder.deleteIcon.setVisibility(View.GONE);
            }
            ///////////////////////////     MIS ANUNCIOS
            else if(operation.compareTo(TextConstants.OPERATION_MY_JOBS)==0){
                holder.starIcon.setVisibility(View.GONE);
                holder.emailIcon.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            new EleaException(e);
        }
        return(item);
    }


    private void emailAction(int position){
        try {
            Intent intent = new Intent(context,NewMessageActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_SEND_NEW_MAIL);
            b.putParcelable(TextConstants.BUNDLE_PARAMETER_JOB,resultList.get(position));
            intent.putExtras(b);
            context.startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void deleteAction(int position){
        try {
            selectedJob = resultList.get(position);
            DialogFragment newFragment = ConfirmDialog.newInstance(context.getResources().getString(R.string.delete_job_title), context.getResources().getString(R.string.delete_job_text), NumericConstants.DELETE_JOB_CONFIRM_FRAGMENT_ID);
            newFragment.show(activity.getFragmentManager(), "deleteJobConfirmation");

        } catch (Exception e) {
            new EleaException(e);
        }
    }


    public void deleteJob(){
        try {
            //borramos la oferta seleccionada
            JobBS.deleteJob(getContext(),selectedJob);

            //volvemos a la lista de Mis trabajos
            Intent intent = new Intent(context, SearchResultListActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_MY_JOBS);
            intent.putExtras(b);
            context.startActivity(intent);
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    private void editAction(int position){
        try {
            //Creamos el Intent
            Intent intent = new Intent(context,JobDetailsActivity.class);
            Bundle b = new Bundle();
            b.putSerializable(TextConstants.BUNDLE_PARAMETER_OPERATION,TextConstants.OPERATION_MODIFY_JOB);
            b.putParcelable(TextConstants.BUNDLE_PARAMETER_JOB,resultList.get(position));
            intent.putExtras(b);
            context.startActivity(intent);

        } catch (Exception e) {
            new EleaException(e);
        }
    }
    
    private void starAction(int position){
        try {

            if(resultList.get(position).getIsFavourite()){
                FavoriteBS.removeFavorite(getContext(),resultList.get(position));
                Utils.showToast(context, context.getString(R.string.result_list_del_favorite));
            }else{
                FavoriteBS.addFavorite(getContext(), resultList.get(position));
                Utils.showToast(context, context.getString(R.string.result_list_add_favorite));
            }
            resultList.get(position).setIsFavourite(!resultList.get(position).getIsFavourite());
        } catch (Exception e) {
            new EleaException(e);
        }
    }

    static class ViewHolder {
        TextView title;
        TextView subTitle;
        TextView sinceWhen;

        CheckBox starIcon;
        ImageView emailIcon;

        ImageView editIcon;
        ImageView deleteIcon;

    }
}
