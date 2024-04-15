/**
 * Mapper class to parse input records and emit student names and grades as key-value pairs.
 */
public class AverageGradeMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text student = new Text();
    private IntWritable grade = new IntWritable();

    /**
     * Parses each input record to extract student name and grade.
     * Emits student name as key and grade as value.
     *
     * @param key     The input key, ignored in this implementation.
     * @param value   The input value containing student name and grade.
     * @param context The context object for writing output.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the thread is interrupted.
     */
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] parts = value.toString().split(" ");
        if (parts.length == 2) {
            student.set(parts[0]);
            grade.set(Integer.parseInt(parts[1]));
            context.write(student, grade);
        }
    }
}
