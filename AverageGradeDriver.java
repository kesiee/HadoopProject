/**
 * Driver class to set up and run the MapReduce job for calculating average grades.
 */
public class AverageGradeDriver {

    /**
     * Sets up and runs the MapReduce job for calculating average grades.
     *
     * @param args Array of command-line arguments: input path and output path.
     * @throws Exception If an error occurs while running the job.
     */
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Average Grade Calculation");

        job.setJarByClass(AverageGradeDriver.class);
        job.setMapperClass(AverageGradeMapper.class);
        job.setReducerClass(AverageGradeReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
