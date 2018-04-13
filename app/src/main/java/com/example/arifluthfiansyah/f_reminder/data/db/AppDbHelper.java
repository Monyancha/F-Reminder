package com.example.arifluthfiansyah.f_reminder.data.db;

import android.util.Log;

import com.example.arifluthfiansyah.f_reminder.data.db.model.Income;
import com.example.arifluthfiansyah.f_reminder.data.db.model.Outcome;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Singleton;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

@Singleton
public class AppDbHelper implements DbHelper {
    private final Realm realm;

    public AppDbHelper(Realm realm) {
        this.realm = realm;
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
