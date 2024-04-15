/**
 * Reducer class to calculate the average grade for each student.
 */
public class AverageGradeReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

    private DoubleWritable result = new DoubleWritable();

    /**
     * Calculates the average grade for each student by summing up their grades
     * and dividing by the number of grades.
     *
     * @param key     The student name.
     * @param values  The list of grades for the student.
     * @param context The context object for writing output.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the thread is interrupted.
     */
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        int count = 0;

        for (IntWritable value : values) {
            sum += value.get();
            count++;
        }

        double average = (double) sum / count;
        result.set(average);
        context.write(key, result);
    }
}
