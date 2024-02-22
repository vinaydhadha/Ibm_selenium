REM   Script: sql-ibm-mf-testing
REM   class

select * from scott.emp;

select * from scott.emp where deptno=30;

select empno,ename,job from scott.emp where deptno=30;

select empno,ename,job from scott.emp where deptno<30;

select empno,ename,job,deptno from scott.emp where deptno<30;

select empno,ename,job,deptno from scott.emp where deptno>20;

select empno,ename,job,deptno from scott.emp where deptno>10 and deptno<30;

select empno,ename,job,deptno from scott.emp where deptno between 10 and 30;

select empno,ename,job,deptno from scott.emp where deptno in(10,30);

select * from scott.emp;

select * from scott.emp where sal>3000;

select * from scott.emp where sal>2000;

