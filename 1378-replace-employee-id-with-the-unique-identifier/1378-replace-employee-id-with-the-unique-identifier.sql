# Write your MySQL query statement below
select employees.name,employeeUNI.unique_id from employees left outer join employeeUNI on employees.id=employeeUNI.id;