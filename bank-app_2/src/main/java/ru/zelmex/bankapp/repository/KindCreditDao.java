package ru.zelmex.bankapp.repository;

import ru.zelmex.bankapp.model.KindCredit;

public class KindCreditDao extends BaseDao<KindCredit> {
    public KindCreditDao() {
        super(KindCredit.class);
    }
}