package com.cliente;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDaoTest.class,
                ProdutoServiceTest.class, ProdutoDAOTest.class,
                VendaDAOTest2.class })
public class AllTests {

}
