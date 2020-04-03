import { Upload, Icon, Modal } from 'antd';

import styles from './index.less'



export default class PDFPreview extends React.Component {
  state = {
    previewVisible: false,
    previewImage: '',
   
  };

  
  componentDidMount(){
    const  url = this.props.documentURL || '/data-solution.pdf';


          // const  url = 'https://raw.githubusercontent.com/mozilla/pdf.js/ba2edeae/examples/learning/helloworld.pdf';

      // Loaded via <script> tag, create shortcut to access PDF.js exports.
      const  pdfjsLib = window['pdfjs-dist/build/pdf'];

      // The workerSrc property shall be specified.
      pdfjsLib.GlobalWorkerOptions.workerSrc = 'pdfjs/build/pdf.worker.js';

      // Asynchronous download of PDF
      const  loadingTask = pdfjsLib.getDocument(url);
      loadingTask.promise.then(function(pdf) {
        console.log('PDF loaded');
        
        // Fetch the first page
        const  pageNumber = 1;
        pdf.getPage(pageNumber).then(function(page) {
          console.log('Page loaded');
          
          const  scale = 1.5;
          const  viewport = page.getViewport({scale: scale});

          // Prepare canvas using PDF page dimensions
          const  canvas = document.getElementById('the-canvas');
          const  context = canvas.getContext('2d');
          canvas.height = viewport.height;
          canvas.width = viewport.width;

          // Render PDF page into canvas context
          const  renderContext = {
            canvasContext: context,
            viewport: viewport
          };
          const  renderTask = page.render(renderContext);
          renderTask.promise.then(function () {
            console.log('Page rendered');
          });
        });
      }, function (reason) {
        // PDF loading error
        console.error(reason);
      });



  }


  render() {
   
   
    


    return (<div style={{textAlign:'center',backgroundColor:'grey', paddingTop: '70px', paddingBottom: '70px'}}>
      
      
      <canvas id="the-canvas" style={{display:'inline'}}></canvas>

    </div>)

     
  }
}