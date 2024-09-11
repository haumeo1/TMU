/**
 * A class for Computers. You should complete the following:
 *
 * - Complete the regular constructor
 * - Complete the "copy" constructor
 * - Complete toString
 * - Complete equals
 */
public class Computer extends ElectronicsProduct
{
    private double screenSize;
    private double ramGB;
    private double hdGB;

    public Computer(String name, double screenSize, double ramGB, double hdGB)
    {
        //-----------Start below here. To do: approximate lines of code = 4
        //
        super(name);
        this.screenSize = screenSize;
        this.ramGB = ramGB;
        this.hdGB = hdGB;
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public Computer(Computer computer)
    {
        //-----------Start below here. To do: approximate lines of code = 4
        //
        // Remember to copy all values from the given computer.
        // See the ElectronicsProduct constructor of this type for an example
        // You can use super to copy the values in ElectronicsProduct
        super(computer);
        this.screenSize = computer.screenSize;
        this.ramGB = computer.ramGB;
        this.hdGB = computer.hdGB;


        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public String toString()
    {
        //-----------Start below here. To do: approximate lines of code = 2
        //
        // Remember to use super to get toString for needed parts
        return super.toString()+", Screen Size: "+screenSize+", RAM: "+ramGB+", hdSpace: "+hdGB;
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }

    public boolean equals(Object other)
    {
        //-----------Start below here. To do: approximate lines of code = 3
        //
        // Use super.equals to compare parts in ElectronicsProduct
        if(!(other instanceof Computer)){
            return false;
        }
        Computer others = (Computer) other;
        return super.equals(others)&&screenSize == others.screenSize&&ramGB == others.ramGB&& hdGB == others.hdGB;
        
        
        
        //-----------------End here. Please do not remove this comment. Reminder: no changes outside the todo regions.
    }
}
