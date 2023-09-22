package pegasus.cl;

import pegasus.pointer.DoubleArrayPointer;
import pegasus.pointer.DoublePointer;

/**
 * Adds two double values.
 */
public class PegasusCLSample {
    /**
     * {@code 1 + 2 = 3}
     */
    public static void main(String[] args) {
        // Initialize inputs
        DoublePointer x = DoublePointer.to(1);
        DoublePointer y = DoublePointer.to(2);

        // Initialize output pointer of size 1
        DoublePointer out = new DoubleArrayPointer(1);

        // Initialize API
        PCL.initialize();

        // Perform kernel operations
        PCL.createKernel(KernelSource.ADD_DOUBLES) // Create a new kernel
                .setInput(0, x) // Set argument 0 to x as input
                .setInput(1, y) // Set argument 1 to y as input
                .setOutput(2, out) // Set argument 2 to out as output
                .execute(1) // Execute with work size 1
                .read(2, out) // Read argument 2 to out
                .dispose(); // Dispose kernel

        System.out.println(out); // Print result

        PCL.dispose(); // Dispose API
    }
}
