package pegasus.cl;

import org.jocl.*;

/**
 * A reference to an OpenCL kernel.
 *
 * @see PCL
 */
public final class Kernel {
    /**
     * Sets the {@code i}th argument of this kernel as an input value.
     *
     * @param i  The index of the argument to set
     * @param in The input values
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setInput(int i, double[] in) {
        memory[i] = PCL.createReadOnlyBuffer(in);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an input value.
     *
     * @param i  The index of the argument to set
     * @param in The input values
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setInput(int i, long[] in) {
        memory[i] = PCL.createReadOnlyBuffer(in);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an input value.
     *
     * @param i  The index of the argument to set
     * @param in The input values
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setInput(int i, float[] in) {
        memory[i] = PCL.createReadOnlyBuffer(in);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an input value.
     *
     * @param i  The index of the argument to set
     * @param in The input values
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setInput(int i, int[] in) {
        memory[i] = PCL.createReadOnlyBuffer(in);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an input value.
     *
     * @param i  The index of the argument to set
     * @param in The input values
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setInput(int i, short[] in) {
        memory[i] = PCL.createReadOnlyBuffer(in);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an input value.
     *
     * @param i  The index of the argument to set
     * @param in The input values
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setInput(int i, byte[] in) {
        memory[i] = PCL.createReadOnlyBuffer(in);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an input value.
     *
     * @param i  The index of the argument to set
     * @param in The input values
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setInput(int i, char[] in) {
        memory[i] = PCL.createReadOnlyBuffer(in);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an output value.
     *
     * @param i   The index of the argument to set
     * @param out The output array
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setOutput(int i, double[] out) {
        memory[i] = PCL.createWriteOnlyBuffer(out);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an output value.
     *
     * @param i   The index of the argument to set
     * @param out The output array
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setOutput(int i, long[] out) {
        memory[i] = PCL.createWriteOnlyBuffer(out);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an output value.
     *
     * @param i   The index of the argument to set
     * @param out The output array
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setOutput(int i, float[] out) {
        memory[i] = PCL.createWriteOnlyBuffer(out);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an output value.
     *
     * @param i   The index of the argument to set
     * @param out The output array
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setOutput(int i, int[] out) {
        memory[i] = PCL.createWriteOnlyBuffer(out);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an output value.
     *
     * @param i   The index of the argument to set
     * @param out The output array
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setOutput(int i, short[] out) {
        memory[i] = PCL.createWriteOnlyBuffer(out);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an output value.
     *
     * @param i   The index of the argument to set
     * @param out The output array
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setOutput(int i, byte[] out) {
        memory[i] = PCL.createWriteOnlyBuffer(out);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Sets the {@code i}th argument of this kernel as an output value.
     *
     * @param i   The index of the argument to set
     * @param out The output array
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel setOutput(int i, char[] out) {
        memory[i] = PCL.createWriteOnlyBuffer(out);
        PCL.setKernelArgument(this, i, Sizeof.cl_mem, Pointer.to(memory[i]));
        return this;
    }

    /**
     * Executes this kernel.
     *
     * @param workSize The work size of this kernel
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel execute(long workSize) {
        PCL.executeKernel(this, workSize);
        return this;
    }

    /**
     * Reads the {@code i}th argument of this kernel after execution.
     *
     * @param i   The index of the argument to read
     * @param out The array of which to output the values to
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel read(int i, double[] out) {
        PCL.readBuffer(memory[i], Sizeof.cl_double * (long) out.length, Pointer.to(out));
        return this;
    }

    /**
     * Reads the {@code i}th argument of this kernel after execution.
     *
     * @param i   The index of the argument to read
     * @param out The array of which to output the values to
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel read(int i, long[] out) {
        PCL.readBuffer(memory[i], Sizeof.cl_long * (long) out.length, Pointer.to(out));
        return this;
    }

    /**
     * Reads the {@code i}th argument of this kernel after execution.
     *
     * @param i   The index of the argument to read
     * @param out The array of which to output the values to
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel read(int i, float[] out) {
        PCL.readBuffer(memory[i], Sizeof.cl_float * (long) out.length, Pointer.to(out));
        return this;
    }

    /**
     * Reads the {@code i}th argument of this kernel after execution.
     *
     * @param i   The index of the argument to read
     * @param out The array of which to output the values to
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel read(int i, int[] out) {
        PCL.readBuffer(memory[i], Sizeof.cl_int * (long) out.length, Pointer.to(out));
        return this;
    }

    /**
     * Reads the {@code i}th argument of this kernel after execution.
     *
     * @param i   The index of the argument to read
     * @param out The array of which to output the values to
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel read(int i, short[] out) {
        PCL.readBuffer(memory[i], Sizeof.cl_short * (long) out.length, Pointer.to(out));
        return this;
    }

    /**
     * Reads the {@code i}th argument of this kernel after execution.
     *
     * @param i   The index of the argument to read
     * @param out The array of which to output the values to
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel read(int i, byte[] out) {
        PCL.readBuffer(memory[i], out.length, Pointer.to(out));
        return this;
    }

    /**
     * Reads the {@code i}th argument of this kernel after execution.
     *
     * @param i   The index of the argument to read
     * @param out The array of which to output the values to
     * @return A reference to this kernel itself ({@code this})
     */
    public Kernel read(int i, char[] out) {
        PCL.readBuffer(memory[i], Sizeof.cl_char * (long) out.length, Pointer.to(out));
        return this;
    }

    /**
     * Disposes this kernel, releasing all its resources and making it no longer operational.
     */
    public void dispose() {
        PCL.disposeKernel(this);
    }

    /**
     * Creates a new kernel.
     *
     * @param program  The {@link cl_program OpenCL program reference} of this kernel
     * @param kernel   The {@link cl_kernel OpenCL kernel reference} of this kernel
     * @param argCount The number of arguments (including output pointers)
     */
    Kernel(cl_program program, cl_kernel kernel, int argCount) {
        this.program = program;
        this.kernel = kernel;
        this.memory = new cl_mem[argCount];
    }

    /**
     * The OpenCL program reference.
     */
    final cl_program program;

    /**
     * The OpenCL kernel reference.
     */
    final cl_kernel kernel;

    /**
     * The OpenCL memory buffers.
     */
    final cl_mem[] memory;
}
