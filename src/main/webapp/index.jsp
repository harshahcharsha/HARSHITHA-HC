/*  Develop a JDBC project using JDBC to append  the fields empno,  empname and basicsalary into the table Emp of the database Employee by getting the fields  through JSP and Generate the report as follows

CREATE TABLE Emp (
  Emp_NO INTEGER PRIMARY KEY,
  Emp_Name TEXT NOT NULL,
  Basicsalary  INTEGER 
);


-- insert
INSERT INTO EMPLOYEE VALUES (101, 'Ramesh', 25000);
INSERT INTO EMPLOYEE VALUES (102, 'Ravi', 20000);
…..
Add 5 records into Emp table of Employee database through Java with JDBC 

and generate a salary report as follows

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````
Salary Report
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Emp_No     : 101
Emp_Name: Ramesh'
Basic           : 25000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Emp_No     : 102
Emp_Name: Ravi
Basic           : 20000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
….
…

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~````
Grand Salary   : 45000
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/

<html>
<body>

<h2>Enter Employee Details</h2>

<form action="insert.jsp" method="post">
    Emp No: <input type="text" name="empno" required><br><br>
    Emp Name: <input type="text" name="empname" required><br><br>
    Salary: <input type="text" name="salary" required><br><br>

    <input type="submit" value="Add employee">
</form>

<br>
<a href="report.jsp">View Salary Report</a>

</body>
</html>
