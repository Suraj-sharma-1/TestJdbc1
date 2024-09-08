import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //How to connect the Database to the object;
//        System.out.println("Hello world!");
//        String url = "jdbc:mysql://localhost:3306/student";
//
//        //Database credentials
//        String username = "root";
//        String password = "Prem";
//
//
//        //Establish the connection
//        try(Connection connection = DriverManager.getConnection(url,username,password)){
//            System.out.println("Connected to the database");
//
//        }
//        catch (SQLException e){
//            System.err.println("Connection failed:"+e.getMessage());


        String url = "jdbc:mysql://localhost:3306/mydatabase";

        //Database credentials

        String username = "root";
        String password = "Prem";
        String query = "select * from employees;";
        String ss = "insert into employees(id,name,job_title,salary) values(1,'suraj11','Developer',1231.0)";
        String dd = "delete from employees where id = 101;";
        String up = "Update employees set job_title = 'enginner1',salary=7546.0 where id=1;";





        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded  successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection estabalished successfully : ");
            Statement stmt = con.createStatement();

            //===========================
           // ResultSet res = stmt.executeQuery(query);   // for retriving the data :

           // System.out.println(res);
//            while(res.next()){
//                int id = res.getInt("id");
//                String name = res.getString("name");
//                String job_title = res.getString("job_title");
//                double salary = res.getDouble("salary");
//                System.out.println("id:" +id + "name:"+ name +" job_title:  " + job_title + " salary: " + salary);
//
//            }
         //   res.close();;



           //=======================================
     //       int rowsaffected =stmt.executeUpdate(ss);     // for inserting the data into the table ;
           // int rowsaffected =stmt.executeUpdate(dd);
            int rowsaffected =stmt.executeUpdate(up);
            if(rowsaffected>0){
                System.out.println("insert successful " +rowsaffected+ " rows affected : ");
            }
            else{
                System.out.println("insertion failed :");
            }
            stmt.close();;
            con.close();



        }
        catch (SQLException e1){
            System.out.println(e1.getMessage());

        }



    }
}