/**
 * Class B extends from Class A. For each method below, finish the method by adding
 * lines of the form:
 *
 * methodX(v + K) for some integer K >= 1
 *
 *      or
 *
 * super.methodX(v + K) for some integer K >= 1
 *
 *      or
 *
 * Some methods may need no additional lines.
 * YOU SHOULD NOT ADD ANY OTHER KINDS OF LINES
 *
 * Ignore the line length hints, as they will not help. Moreover, you should
 * examine InheritanceTester to see what the expected outputs are. That will
 * help you figure out what the different constant K values should be and which
 * methods are called in where.
 */
public class B extends A
{
    public B() {
        super();
    }

    public void methodA1(int v) {
        System.out.println("methodA1 in B called with value " + v);

        //-----------Start below here. To do: approximate lines of code = 4
        //
        int temp = v+19;
        super.methodA1(temp);
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
    public void methodA3(int v) {
        System.out.println("methodA3 in B called with value " + v);

        //-----------Start below here. To do: approximate lines of code = 4
        //
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public void methodB1(int v) {
        System.out.println("methodB1 in B called with value " + v);

        //-----------Start below here. To do: approximate lines of code = 4
        //
        
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public void methodB2(int v) {
        System.out.println("methodB2 in B called with value " + v);

        //-----------Start below here. To do: approximate lines of code = 4
        //
        int temp;
        temp = v+13;
        methodB1(temp);
        temp = v+72;
        methodA1(temp);
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
