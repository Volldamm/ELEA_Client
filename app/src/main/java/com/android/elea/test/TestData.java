package com.android.elea.test;

import com.android.elea.beans.Job;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Borja on 30/04/2015.
 */
public class TestData {




    public List<Job> simulateSearchResults(String searchText,String provinceStr, String townStr){

        List<Job> jobList = new ArrayList<Job>();
        Job job;


        job = new Job();

        job.setTitle("Empleada Hogar");
        job.setSubtitle("Bilbao, 15€/h");
        job.setSinceWhen("Hace 3 días");
        job.setIsFavourite(false);
        jobList.add(job);


        job = new Job();

        job.setTitle("Informatico");
        job.setSubtitle("Barcelona, 25€/h");
        job.setSinceWhen("Hace 6 días");
        job.setIsFavourite(true);
        jobList.add(job);

        job = new Job();

        job.setTitle("Lampista");
        job.setSubtitle("Sevilla, 60€/día");
        job.setSinceWhen("Hace 1 semana");
        job.setIsFavourite(false);
        jobList.add(job);


        job = new Job();

        job.setTitle("Electricista");
        job.setSubtitle("Vitoria, 15€/h");
        job.setSinceWhen("Hace 2 semanas");
        job.setIsFavourite(false);
        jobList.add(job);


        job = new Job();

        job.setTitle("Panadero");
        job.setSubtitle("Leon, 60€/día");
        job.setSinceWhen("Hace 2 semanas");
        job.setIsFavourite(true);
        jobList.add(job);

        job = new Job();

        job.setTitle("Cuidador");
        job.setSubtitle("Sevilla, 60€/día");
        job.setSinceWhen("Hace 2 semanas");
        job.setIsFavourite(false);
        jobList.add(job);

        job = new Job();

        job.setTitle("Canguro");
        job.setSubtitle("Madrid, 10€/hora");
        job.setSinceWhen("Hace 2 semanas");
        job.setIsFavourite(false);
        jobList.add(job);


        job = new Job();

        job.setTitle("Empleada Hogar");
        job.setSubtitle("Bilbao, 15€/h");
        job.setSinceWhen("Hace 3 días");
        job.setIsFavourite(false);
        jobList.add(job);


        job = new Job();

        job.setTitle("Informatico");
        job.setSubtitle("Barcelona, 25€/h");
        job.setSinceWhen("Hace 6 días");
        job.setIsFavourite(true);
        jobList.add(job);

        job = new Job();

        job.setTitle("Lampista");
        job.setSubtitle("Sevilla, 60€/día");
        job.setSinceWhen("Hace 1 semana");
        job.setIsFavourite(false);
        jobList.add(job);


        job = new Job();

        job.setTitle("Electricista");
        job.setSubtitle("Vitoria, 15€/h");
        job.setSinceWhen("Hace 2 semanas");
        job.setIsFavourite(false);
        jobList.add(job);


        job = new Job();

        job.setTitle("Panadero");
        job.setSubtitle("Leon, 60€/día");
        job.setSinceWhen("Hace 2 semanas");
        job.setIsFavourite(true);
        jobList.add(job);

        job = new Job();

        job.setTitle("Cuidador");
        job.setSubtitle("Sevilla, 60€/día");
        job.setSinceWhen("Hace 2 semanas");
        job.setIsFavourite(false);
        jobList.add(job);

        job = new Job();

        job.setTitle("Canguro");
        job.setSubtitle("Madrid, 10€/hora");
        job.setSinceWhen("Hace 2 semanas");
        job.setIsFavourite(false);
        jobList.add(job);


        return jobList;
    }


}
