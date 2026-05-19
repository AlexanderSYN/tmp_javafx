package ru.zelmex.bankapp.repository;
import ru.zelmex.bankapp.model.Client;
public class ClientDao extends BaseDao<Client> {
    public ClientDao() {
        super(Client.class);
    }
}