package org.odk.collect.android.myapplication.forms;

import android.content.Context;

import org.odk.collect.android.application.Collect;
import org.odk.collect.android.myapplication.database.PracticalActionDatabase;
import org.odk.collect.android.myapplication.database.base.BaseLocalDataSourceRX;
import org.odk.collect.android.myapplication.database.dao.PracticalActionFormsDAO;

import java.util.ArrayList;

import io.reactivex.Completable;
import io.reactivex.functions.Action;

public class FormsLocalSource implements BaseLocalDataSourceRX<PraticalActionForm> {

    private static FormsLocalSource INSTANCE = null;
    private PracticalActionFormsDAO dao;

    public static FormsLocalSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FormsLocalSource();
        }
        return INSTANCE;
    }

    private FormsLocalSource() {
        Context context = Collect.getInstance();
        PracticalActionDatabase database = PracticalActionDatabase.getDatabase(context);//todo inject context
        this.dao = database.getPracticalActionFormsDAO();
    }


    @Override
    public Completable save(PraticalActionForm... items) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {

            }
        });
    }

    @Override
    public Completable save(ArrayList<PraticalActionForm> items) {
        return null;
    }
}
