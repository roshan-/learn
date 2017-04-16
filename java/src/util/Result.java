package util;

/**
 * Created by rdiwakar on 4/16/2017.
 */
public class Result {
    private long result;
    private long timeToCompute;

    public long getTimeToCompute() {
        return timeToCompute;
    }

    public long getResult() {
        return result;
    }

    public Result(long _result, long _timeToCompute) {
        result= _result;
        timeToCompute= _timeToCompute;
    }
}
