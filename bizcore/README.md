
=======
# skynet-common-app-framework
Common App Framework, a replacement of modern app

## 支持返回一个blob类型， 一个返回图片的例子

```
	public BlobObject helloImage2(int width, int height, String note) throws IOException {
		
		BlobObject blob = new BlobObject();
		
		int internalWidth = outOfThen(width,10,1400,600);
		int internalHeight = outOfThen(height,10,1400,400);
		
		BufferedImage off_Image =
				  new BufferedImage(internalWidth, internalHeight,
				                    BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = off_Image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		Font f = new Font("Monospaced", Font.BOLD, 14);
		g2.setFont(f);
		String text=String.format("%s(%dX%d)", note,internalWidth,internalHeight);
		g2.drawString(text,1,15); 
		//WritableRaster raster = bufferedImage .getRaster();
		//DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
		Shape shape = new Rectangle2D.Double(1, 1,
				internalWidth-2,
				internalHeight-2);
		g2.draw(shape);
		shape = new Line2D.Double(0, 0, internalWidth, internalHeight);
		g2.draw(shape);
		shape = new Line2D.Double(internalWidth, 0, 0, internalHeight);
		g2.draw(shape);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		ImageIO.write(off_Image, "png", bos);
		blob.setData(bos.toByteArray());
		blob.setMimeType(BlobObject.TYPE_PNG);
		//BlobObject.TYPE_XLSX
		return blob;
		
	}

```
