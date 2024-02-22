REM   Script: 19th feb 2024
REM   class

select  * from scott.emp;

select distinct deptno from scott.emp;

select empno, ename, e.deptno, dname  
from scott.emp e, scott.dept d 
where e.deptno=d.deptno;

select * from scott.dept;

select empno, ename, e.deptno, dname  
join scott.emp e, scott.dept d 
on e.deptno=d.deptno;

select empno, ename, e.deptno, dname  
join scott.emp e 
    inner join scott.dept d 
on e.deptno=d.deptno;

select empno, ename, e.deptno, dname  
from scott.emp e 
    inner join scott.dept d 
on e.deptno=d.deptno;

select empno, ename, e.deptno, dname  
from scott.emp e 
right join scott.dept d 
on e.deptno=d.deptno;

