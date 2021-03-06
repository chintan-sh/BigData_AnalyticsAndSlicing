

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AllLab_Skeleton.Lab2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

/**
 *
 * @author pooja
 */
public class CompositeKeyWritable implements Writable, WritableComparable<CompositeKeyWritable> {
    private String deptNo;
    private String lastName;
    
    public CompositeKeyWritable(){
        
    }
    
    public CompositeKeyWritable(String d, String l){
        this.deptNo =d;
        this.lastName= l;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
    @Override
    public void write(DataOutput d) throws IOException {
        WritableUtils.writeString(d, deptNo);
        WritableUtils.writeString(d, lastName);
    }

    @Override
    public void readFields(DataInput di) throws IOException {
        deptNo = WritableUtils.readString(di);
        lastName = WritableUtils.readString(di);
    }

    @Override
    public int compareTo(CompositeKeyWritable o) {
        int result = deptNo.compareTo(o.deptNo);
        if(result ==0){
            result = lastName.compareTo(o.lastName);
        }
        return result;
    }
    
    public String toString(){
        return (new StringBuilder().append(deptNo).append("\t").append(lastName).toString());
    }
    
}
