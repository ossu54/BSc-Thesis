package cluster.hdfs;

import java.awt.image.BufferedImage;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.hadoop.io.ObjectWritable;
import org.apache.hadoop.io.Writable;
import org.apache.spark.input.Configurable;

public class TiffImageWritable implements Writable{
	private BufferedImage img;
	
	public TiffImageWritable(BufferedImage img) {
		this.img = img;
	}
	public TiffImageWritable() {
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		ImageInputStream iis = javax.imageio.ImageIO.createImageInputStream(in);
		img = ImageIO.read(iis);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		ImageOutputStream ios = javax.imageio.ImageIO.createImageOutputStream(out);
		ImageIO.write(img, "tif", ios);
	}
	public Integer getHeight(){
		return img.getHeight();
	}

	public BufferedImage getImg(){
		return img;
	}

}
