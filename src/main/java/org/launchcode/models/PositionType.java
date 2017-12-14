package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public class PositionType extends JobField {

    public PositionType(String value) {
        super(value);
    }

}
/*
1*when does toString method get called?
2*structure of enum
3*whats this returning:ArrayList<JobField> employers = jobData.findByColumnAndValue(JobFieldType.EMPLOYER, "LaunchCode");
4* Find all jobs at LaunchCode
        ArrayList<Job> jobsAtLaunchcode = jobData.findByColumnAndValue(JobFieldType.EMPLOYER, "LaunchCode");
5* // The selected search options?
6* There's one more class in models that we need to introduce.
private JobFieldType searchField = JobFieldType.ALL;



        */