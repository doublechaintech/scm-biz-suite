import React, { useMemo, useRef } from 'react';
import ReactQuill, { Quill } from 'react-quill';
import 'react-quill/dist/quill.snow.css';
import ImageService from '../../services/ImageService';
import ImageResize from '@taoqf/quill-image-resize-module';

Quill.register('modules/imageResize', ImageResize);


const container = [

  [{ size: [] }],
  ['bold', 'italic', 'underline', 'strike', 'blockquote'],
  [{ list: 'ordered' }, { list: 'bullet' }],
  ['link', 'image'],
  ['clean'],
  ['code-block'],
];


function selectLocalImage(param, quillRef) {
  console.log('selectLocalImage', param, quillRef);
  const input = document.createElement('input');
  input.setAttribute('type', 'file');
  input.click();


  // Listen upload local image and save to server
  input.onchange = () => {
    const file = input.files[0];

    // file type is only image.
    if (/^image\//.test(file.type)) {
      //saveToServer(file);
      const quillEditor = quillRef.current.getEditor();
      const range = quillEditor.getSelection(true);
      const reader = new FileReader();
      reader.readAsDataURL(file);

      //reference https://quilljs.com/docs/api/

      reader.onload = () => {
        const { uploadOneImage } = ImageService;
        const image = { name: 'noname', mimeType: file.type, encodeContent: reader.result };
        quillEditor.insertText(range.index, '正在上传.....', 'bold', true);
        quillEditor.disable();
        uploadOneImage({ ...image }).then((response) => {
          if (!response.class) {
            alert('图片上传失败(response.class)!');
            return;
          }
          if (!response.class.indexOf('ImageUploadResponse') < 0) {
            alert('图片上传失败!-ImageUploadResponse');
            return;
          }
          const imageId = response.remoteUrl;

          quillEditor.deleteText(range.index, '正在上传.....'.length);
          quillEditor.insertEmbed(range.index, 'image', `${imageId}`);
          quillEditor.enable(true);
        });


      };
      console.log('File', file.type);

    } else {
      console.warn('You could only upload images.');
    }
  };
}


export default function RichEditor(props) {

  const { value, onChange } = props;

  const quillRef = useRef(null);
  const modules = useMemo(() => ({
    imageResize: {},
    toolbar: {
      container: container,
      handlers: { image: (value) => selectLocalImage(value, quillRef) },
    },
  }), []);


  return (
    <ReactQuill
      ref={quillRef}
      style={{ minHeight: '300px', height: '400px' }}
      modules={modules}
      theme='snow'
      value={value}
      onChange={onChange} />
  );
}


