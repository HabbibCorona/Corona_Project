import java.sql.*;
//Como adicionar um driver do MySQL:
// 1. Vá até File->Project Structure->Libraries
// 2. Clica no "+" e selecione "From Meven"
// 3. Na caixa de texto pesquisar por "mysql:mysql-connector-java:versão-recente"
public class AddInstitution
{
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/db_Habbib?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&useSSL=false";
    static final String USERNAME = "root";
    static final String PASSWORD = "password";

    static final String DEFAULT_QUERY = "SELECT * FROM db_Habbib.Instituicao";

    public static void main(String[] args)
    {
        try
        {
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(DEFAULT_QUERY);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            //System.out.printf("Vai sair: \n");

            for(int i = 1; i <= numberOfColumns; i++)
            {
                System.out.printf("%-12s\t", metaData.getColumnName(i));

            }
            System.out.println();
            while(resultSet.next())
            {
                for(int j = 1; j <= numberOfColumns; j++)
                {
                    System.out.printf("%-12s\t", resultSet.getObject( j ));
                }
                System.out.println();
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }


    }
}
