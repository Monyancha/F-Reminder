package com.example.arifluthfiansyah.f_reminder.controller;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.arifluthfiansyah.f_reminder.model.Outcome;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class OutcomeController {

    private static OutcomeController instance;
    private final Realm realm;

    public OutcomeController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static OutcomeController with(Fragment fragment) {
        if (instance == null) {
            instance = new OutcomeController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static OutcomeController with(Activity activity) {
        if (instance == null) {
            instance = new OutcomeController(activity.getApplication());
        }
        return instance;
    }

    public static OutcomeController with(Application application) {
        if (instance == null) {
            instance = new OutcomeController(application);
        }
        return instance;
    }

    public static OutcomeController getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    public void addOutcome(final Outcome add) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @ParametersAreNonnullByDefault
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(add);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("OutcomeController", "Success add");
            }
        }, new Realm.Transaction.OnError() {
            @ParametersAreNonnullByDefault
            @Override
            public void onError(Throwable error) {
                Log.d("OutcomeController", error.getMessage());
            }
        });
    }

    public void updateOutcome(final Outcome update) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @ParametersAreNonnullByDefault
            @Override
            public void execute(Realm realm) {
                Outcome outcome = realm.where(Outcome.class).equalTo("id", update.getId()).findFirst();
                if (outcome != null) {
                    outcome.setTitle(update.getTitle());
                    outcome.setContent(update.getContent());
                    outcome.setPrice(update.getPrice());
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("OutcomeController", "Success update");
            }
        }, new Realm.Transaction.OnError() {
            @ParametersAreNonnullByDefault
            @Override
            public void onError(Throwable error) {
                Log.d("OutcomeController", error.getMessage());
            }
        });
    }

    public Outcome getOutcomeById(long id) {
        return realm.where(Outcome.class).equalTo("id", id).findFirst();
    }

    public Outcome getOutcomeByLast() {
        return realm.where(Outcome.class).sort("id", Sort.DESCENDING).findFirst();
    }

    public List<Outcome> getOutcomes() {
        List<Outcome> outcomes = new ArrayList<>();
        RealmResults<Outcome> results = realm.where(Outcome.class).sort("id", Sort.DESCENDING).findAll();
        for (Outcome o : results) {
            outcomes.add(new Outcome(o.getId(), o.getTitle(), o.getContent(), o.getPrice(), o.getDate()));
        }
        return outcomes;
    }

    public void deleteOutcomeById(final long id) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @ParametersAreNonnullByDefault
            @Override
            public void execute(Realm realm) {
                Outcome results = realm.where(Outcome.class).equalTo("id", id).findFirst();
                if (results != null) {
                    results.deleteFromRealm();
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("OutcomeController", "Success delete");
            }
        }, new Realm.Transaction.OnError() {
            @ParametersAreNonnullByDefault
            @Override
            public void onError(Throwable error) {
                Log.d("OutcomeController", error.getMessage());
            }
        });
    }

    public void deleteOutcomes() {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @ParametersAreNonnullByDefault
            @Override
            public void execute(Realm realm) {
                RealmResults<Outcome> results = realm.where(Outcome.class).findAll();
                results.deleteAllFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("OutcomeController", "Success delete");
            }
        }, new Realm.Transaction.OnError() {
            @ParametersAreNonnullByDefault
            @Override
            public void onError(Throwable error) {
                Log.d("OutcomeController", error.getMessage());
            }
        });
    }
}
