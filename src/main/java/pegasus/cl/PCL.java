package pegasus.cl;

import org.jocl.*;
import pegasus.exception.IllegalInstanceException;

import java.util.HashSet;
import java.util.Set;

/**
 * The Pegasus OpenCL API.
 *
 * @see Kernel
 */
public final class PCL {
    /**
     * Returns whether this API has been initialized.
     *
     * @return {@code true} if this API has been initialized, and is operational
     */
    public static boolean initialized() {
        return initialized;
    }

    /**
     * Initializes this API.
     *
     * @throws CLException When OpenCL fails to initialize
     */
    public static void initialize() throws CLException {
        CL.setExceptionsEnabled(true);

        cl_platform_id[] platformIds = new cl_platform_id[1];
        CL.clGetPlatformIDs(1, platformIds, null);
        cl_platform_id platformId = platformIds[0];

        cl_device_id[] deviceIds = new cl_device_id[1];
        CL.clGetDeviceIDs(platformId, CL.CL_DEVICE_TYPE_GPU, 1, deviceIds, null);
        deviceId = deviceIds[0];

        context = CL.clCreateContext(null, 1, new cl_device_id[]{deviceId},
                null, null, null);

        commandQueue = CL.clCreateCommandQueueWithProperties(context, deviceId, null, null);

        kernels.clear();
        initialized = true;
    }

    /**
     * Disposes this API, and all its resources.
     *
     * @throws CLException When OpenCL fails to release its resources
     */
    public static void dispose() throws CLException {
        kernels.forEach(PCL::disposeKernel);
        kernels.clear();

        CL.clReleaseCommandQueue(commandQueue);
        CL.clReleaseContext(context);
        CL.clReleaseDevice(deviceId);

        deviceId = null;
        context = null;
        commandQueue = null;
        initialized = false;
    }

    /**
     * Creates and returns a new kernel instance.
     *
     * @param source The source of the kernel
     * @return The created kernel instance
     * @see KernelSource
     * @see KernelSource#ADD_DOUBLES
     * @see KernelSource#SUBTRACT_DOUBLES
     * @see KernelSource#MULTIPLY_DOUBLES
     * @see KernelSource#DIVIDE_DOUBLES
     * @see KernelSource#SQRT_DOUBLE
     */
    public static Kernel createKernel(KernelSource source) {
        cl_program program = CL.clCreateProgramWithSource(context, 1, new String[]{source.code()}, null, null);
        CL.clBuildProgram(program, 0, null, null, null, null);
        cl_kernel kernel = CL.clCreateKernel(program, source.name(), null);

        Kernel result = new Kernel(program, kernel, source.argCount());
        kernels.add(result);
        return result;
    }

    /**
     * Creates and returns a read-only memory buffer.
     *
     * @param in The input values
     * @return The created buffer
     */
    static cl_mem createReadOnlyBuffer(double[] in) {
        return CL.clCreateBuffer(context, CL.CL_MEM_READ_ONLY | CL.CL_MEM_COPY_HOST_PTR,
                Sizeof.cl_double * (long) in.length, Pointer.to(in), null);
    }

    /**
     * Creates and returns a read-only memory buffer.
     *
     * @param in The input values
     * @return The created buffer
     */
    static cl_mem createReadOnlyBuffer(long[] in) {
        return CL.clCreateBuffer(context, CL.CL_MEM_READ_ONLY | CL.CL_MEM_COPY_HOST_PTR,
                Sizeof.cl_long * (long) in.length, Pointer.to(in), null);
    }

    /**
     * Creates and returns a read-only memory buffer.
     *
     * @param in The input values
     * @return The created buffer
     */
    static cl_mem createReadOnlyBuffer(float[] in) {
        return CL.clCreateBuffer(context, CL.CL_MEM_READ_ONLY | CL.CL_MEM_COPY_HOST_PTR,
                Sizeof.cl_float * (long) in.length, Pointer.to(in), null);
    }

    /**
     * Creates and returns a read-only memory buffer.
     *
     * @param in The input values
     * @return The created buffer
     */
    static cl_mem createReadOnlyBuffer(int[] in) {
        return CL.clCreateBuffer(context, CL.CL_MEM_READ_ONLY | CL.CL_MEM_COPY_HOST_PTR,
                Sizeof.cl_int * (long) in.length, Pointer.to(in), null);
    }

    /**
     * Creates and returns a read-only memory buffer.
     *
     * @param in The input values
     * @return The created buffer
     */
    static cl_mem createReadOnlyBuffer(short[] in) {
        return CL.clCreateBuffer(context, CL.CL_MEM_READ_ONLY | CL.CL_MEM_COPY_HOST_PTR,
                Sizeof.cl_short * (long) in.length, Pointer.to(in), null);
    }

    /**
     * Creates and returns a read-only memory buffer.
     *
     * @param in The input values
     * @return The created buffer
     */
    static cl_mem createReadOnlyBuffer(byte[] in) {
        return CL.clCreateBuffer(context, CL.CL_MEM_READ_ONLY | CL.CL_MEM_COPY_HOST_PTR,
                in.length, Pointer.to(in), null);
    }

    /**
     * Creates and returns a read-only memory buffer.
     *
     * @param in The input values
     * @return The created buffer
     */
    static cl_mem createReadOnlyBuffer(char[] in) {
        return CL.clCreateBuffer(context, CL.CL_MEM_READ_ONLY | CL.CL_MEM_COPY_HOST_PTR,
                Sizeof.cl_char * (long) in.length, Pointer.to(in), null);
    }

    /**
     * Creates and returns a write-only memory buffer.
     *
     * @param out The output array
     * @return The created buffer
     */
    static cl_mem createWriteOnlyBuffer(double[] out) {
        return CL.clCreateBuffer(context, CL.CL_MEM_WRITE_ONLY,
                Sizeof.cl_double * (long) out.length, null, null);
    }

    /**
     * Creates and returns a write-only memory buffer.
     *
     * @param out The output array
     * @return The created buffer
     */
    static cl_mem createWriteOnlyBuffer(long[] out) {
        return CL.clCreateBuffer(context, CL.CL_MEM_WRITE_ONLY,
                Sizeof.cl_long * (long) out.length, null, null);
    }

    /**
     * Creates and returns a write-only memory buffer.
     *
     * @param out The output array
     * @return The created buffer
     */
    static cl_mem createWriteOnlyBuffer(float[] out) {
        return CL.clCreateBuffer(context, CL.CL_MEM_WRITE_ONLY,
                Sizeof.cl_float * (long) out.length, null, null);
    }

    /**
     * Creates and returns a write-only memory buffer.
     *
     * @param out The output array
     * @return The created buffer
     */
    static cl_mem createWriteOnlyBuffer(int[] out) {
        return CL.clCreateBuffer(context, CL.CL_MEM_WRITE_ONLY,
                Sizeof.cl_int * (long) out.length, null, null);
    }

    /**
     * Creates and returns a write-only memory buffer.
     *
     * @param out The output array
     * @return The created buffer
     */
    static cl_mem createWriteOnlyBuffer(short[] out) {
        return CL.clCreateBuffer(context, CL.CL_MEM_WRITE_ONLY,
                Sizeof.cl_short * (long) out.length, null, null);
    }

    /**
     * Creates and returns a write-only memory buffer.
     *
     * @param out The output array
     * @return The created buffer
     */
    static cl_mem createWriteOnlyBuffer(byte[] out) {
        return CL.clCreateBuffer(context, CL.CL_MEM_WRITE_ONLY,
                out.length, null, null);
    }

    /**
     * Creates and returns a write-only memory buffer.
     *
     * @param out The output array
     * @return The created buffer
     */
    static cl_mem createWriteOnlyBuffer(char[] out) {
        return CL.clCreateBuffer(context, CL.CL_MEM_WRITE_ONLY,
                Sizeof.cl_char * (long) out.length, null, null);
    }

    /**
     * Sets the {@code i}th argument of the provided kernel {@code k}.
     *
     * @param k   The kernel of which to set the argument of
     * @param i   The index of the argument to set
     * @param s   The size of the pointer
     * @param ptr The pointer object to set to
     */
    @SuppressWarnings("SameParameterValue")
    static void setKernelArgument(Kernel k, int i, long s, Pointer ptr) {
        CL.clSetKernelArg(k.kernel, i, s, ptr);
    }

    /**
     * Executes the provided kernel {@code k}.
     *
     * @param k        The kernel of which to execute
     * @param workSize The work size of the execution
     */
    static void executeKernel(Kernel k, long workSize) {
        CL.clEnqueueNDRangeKernel(commandQueue, k.kernel, 1, null, new long[]{workSize},
                null, 0, null, null);
    }

    /**
     * Reads a memory buffer.
     *
     * @param m   The memory buffer of which to read from
     * @param s   The size of the variable to read
     * @param ptr The pointer to write the result to
     */
    static void readBuffer(cl_mem m, long s, Pointer ptr) {
        CL.clEnqueueReadBuffer(commandQueue, m, CL.CL_TRUE, 0, s, ptr, 0, null, null);
    }

    /**
     * Disposes the provided kernel {@code k}.
     *
     * @param k The kernel of which to dispose
     */
    static void disposeKernel(Kernel k) {
        for (cl_mem mem : k.memory) {
            CL.clReleaseMemObject(mem);
        }

        CL.clReleaseKernel(k.kernel);
        CL.clReleaseProgram(k.program);

        kernels.remove(k);
    }

    /**
     * Whether this API has been initialized.
     */
    private static boolean initialized = false;

    /**
     * The OpenCL device ID reference.
     */
    private static cl_device_id deviceId;

    /**
     * The OpenCL context reference.
     */
    private static cl_context context;

    /**
     * The OpenCL command queue reference.
     */
    private static cl_command_queue commandQueue;

    /**
     * The set of all created kernels.
     */
    private static final Set<Kernel> kernels = new HashSet<>();

    /**
     * Private constructor to prevent instantiation.
     */
    private PCL() {
        throw new IllegalInstanceException(this);
    }
}
