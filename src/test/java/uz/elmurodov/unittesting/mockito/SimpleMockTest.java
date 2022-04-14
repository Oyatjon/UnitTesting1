package uz.elmurodov.unittesting.mockito;

import org.assertj.core.api.AssertJProxySetup;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class SimpleMockTest {


    @Mock
    Database databaseMock;

//    @BeforeEach
//    void beforeEach() {
//        databaseMock = Mockito.mock(Database.class);
//    }

    @Test
    public void testQuery() {
        // databaseMock = Mockito.mock(Database.class);
        Assertions.assertThat(databaseMock).isNotNull();
        Mockito.when(databaseMock.isAvailable()).thenReturn(true);
        Service t = new Service(databaseMock);
        boolean check = t.query("select version()");
        Assertions.assertThat(check).isTrue();
    }

    @Test
    public void testToString() {
        // databaseMock = Mockito.mock(Database.class);
        Assertions.assertThat(databaseMock).isNotNull();
        Mockito.when(databaseMock.getUniqueId()).thenReturn(102);
        Service service = new Service(databaseMock);
        String stringDataOfServiceObject = service.toString();
        Assertions.assertThat(stringDataOfServiceObject).isNotNull();
        System.out.println(stringDataOfServiceObject);
    }


    @Test
    public void testFindByName() {
        // databaseMock = Mockito.mock(Database.class);
        Service service = new Service(databaseMock);
        Mockito.when(databaseMock.findByName(Mockito.anyString())).thenReturn("Here we are");
        String message = service.find("oyatjsadffon");
        System.out.println("message = " + message);
    }

    @Test
    public void testFindByName2() {
        // databaseMock = Mockito.mock(Database.class);

        Mockito.when(databaseMock.findByName("asliddin"))
                .thenThrow(new RuntimeException("Romances is not allowed to hit this method 🤣"));

        Service service = new Service(databaseMock);

        Assertions.assertThatThrownBy(() -> service.find("asliddin"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Romances is not allowed to hit this method 🤣");
    }

    @Test
    public void testFindByNameVerify() {
        // databaseMock = Mockito.mock(Database.class);
        Service service = new Service(databaseMock);
//        Mockito.when(databaseMock.findByName(Mockito.anyString())).thenReturn("Here we are");
//        String message = service.find("oyatjon");
//        Mockito.when(databaseMock.findByName(Mockito.anyString())).thenReturn("Here we are");
//        String message2 = service.find("oyatjon");
//        Mockito.when(databaseMock.findByName(Mockito.anyString())).thenReturn("Here we are");
//        String message3 = service.find("oyatjon");
//        System.out.println("message = " + message);
        databaseMock.findByName("oyatjon");
        databaseMock.findByName("oyatjon");
        databaseMock.findByName("oyatjon");
        databaseMock.findByName("oyatjon");
        databaseMock.findByName("oyatjon");

//        Mockito.verify(databaseMock).findByName("oyatjon");
        Mockito.verify(databaseMock, Mockito.atLeast(3)).findByName("oyatjon");
        Mockito.verify(databaseMock, Mockito.never()).getUniqueId();
        Mockito.verify(databaseMock, Mockito.never()).getUniqueId();
        Mockito.verify(databaseMock, Mockito.atLeastOnce()).findByName("oyatjon");


        Mockito.verifyNoMoreInteractions(databaseMock);

    }

}
