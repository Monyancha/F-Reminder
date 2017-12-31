package com.example.arifluthfiansyah.f_reminder.controller;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.arifluthfiansyah.f_reminder.model.Income;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Arif Luthfiansyah on 11-Dec-17.
 */

public class IncomeController {

    private static IncomeController instance;
    private final Realm realm;

    public IncomeController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static IncomeController with(Fragment fragment) {
        if (instance == null) {
            instance = new IncomeController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static IncomeController with(Activity activity) {
        if (instance == null) {
            instance = new IncomeController(activity.getApplication());
        }
        return instance;
    }

    public static IncomeController with(Application application) {
        if (instance == null) {
            instance = new IncomeController(application);
        }
        return instance;
    }

    public static IncomeController getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    public void addIncome(final Income add) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @ParametersAreNonnullByDefault
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(add);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("IncomeController", "Success add");
            }
        }, new Realm.Transaction.OnError() {
            @ParametersAreNonnullByDefault
            @Override
            public void onError(Throwable error) {
                Log.d("IncomeController", error.getMessage());
            }
        });
    }

    public void updateIncome(final Income update) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @ParametersAreNonnullByDefault
            @Override
            public void execute(Realm realm) {
                Income income = realm.where(Income.class).equalTo("id", update.getId()).findFirst();
                if (income != null) {
                    income.setTitle(update.getTitle());
                    income.setPrice(update.getPrice());
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("IncomeController", "Success update");
            }
        }, new Realm.Transaction.OnError() {
            @ParametersAreNonnullByDefault
            @Override
            public void onError(Throwable error) {
                Log.d("IncomeController", error.getMessage());
            }
        });
    }

    public Income getIncomeById(long id) {
        return realm.where(Income.class).equalTo("id", id).findFirst();
    }

    public Income getIncomeByLast() {
        return realm.where(Income.class).sort("id", Sort.DESCENDING).findFirst();
    }

    public List<Income> getIncomes() {
        List<Income> incomes = new ArrayList<>();
        RealmResults<Income> results = realm.where(Income.class).sort("id", Sort.DESCENDING).findAll();
        for (Income i : results) {
            incomes.add(new Income(i.getId(), i.getTitle(), i.getPrice(), i.getDate()));
        }
        return incomes;
    }

    public void deleteIncomeById(final long id) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @ParametersAreNonnullByDefault
            @Override
            public void execute(Realm realm) {
                Income results = realm.where(Income.class).equalTo("id", id).findFirst();
                if (results != null) {
                    results.deleteFromRealm();
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("IncomeController", "Success delete");
            }
        }, new Realm.Transaction.OnError() {
            @ParametersAreNonnullByDefault
            @Override
            public void onError(Throwable error) {
                Log.d("IncomeController", error.getMessage());
            }
        });
    }

    public void deleteIncomes() {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @ParametersAreNonnullByDefault
            @Override
            public void execute(Realm realm) {
                RealmResults<Income> results = realm.where(Income.class).findAll();
                results.deleteAllFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.d("IncomeController", "Success delete");
            }
        }, new Realm.Transaction.OnError() {
            @ParametersAreNonnullByDefault
            @Override
            public void onError(Throwable error) {
                Log.d("IncomeController", error.getMessage());
            }
        });
    }
}
