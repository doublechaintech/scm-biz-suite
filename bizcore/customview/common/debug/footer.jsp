</div>
   <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../bootstrap/ie10-viewport-bug-workaround.js"></script>
	<script src="../bootstrap/jquery.min.js"></script>

<script>
$(function(){
	if(typeof onPageLoaded === "function") {
		onPageLoaded();
		return;
	}
	console.log("<%out.write("asdfasdfas");%>没有定义函数 onPageLoaded()");
});
</script>

</body>
</html>
