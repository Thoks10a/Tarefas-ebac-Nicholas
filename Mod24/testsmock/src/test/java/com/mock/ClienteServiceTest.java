package com.mock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import com.mock.dao.ClienteDaoMock;
import com.mock.service.ClienteService;

public class ClienteServiceTest {

    @Test
    public void salvarTeste() {
        ClienteDaoMock csm = new ClienteDaoMock();
        ClienteService cs = new ClienteService(csm);

        String returned = cs.salvar();

        Assert.assertEquals("Sucesso", returned);
    }

}
