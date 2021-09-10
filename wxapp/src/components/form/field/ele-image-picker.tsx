import { useEffect, useState } from 'react';
import { isEmpty, noop } from '@/nice-router/nice-router-util';
import uploadFiles from '@/service/file-upload/upload-files';
import { Text, View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import { AtImagePicker, AtProgress } from 'taro-ui';
import { ImageLike } from '@/nice-router/nice-router-types';

import './styles.scss';

// TODO image picker 有个bug，可以暂时等待Taro ui 升级，要修改源码，https://github.com/NervJS/taro-ui/pull/1290

type EleImage = {
  imageUrl?: string;
};

type EleAtImage = {
  url?: string;
};

type EleImagePickerProps = {
  value: EleImage[] | string;
  onChange?: (imageList: ImageLike[]) => void;
  maxLength?: number;
  disabled?: boolean;
  brief?: string;
};

function EleImagePicker(props: EleImagePickerProps) {
  const { value = [], onChange = noop, maxLength = 4, disabled, brief } = props;

  const [files, setFiles] = useState<EleAtImage[]>([]);
  const [progress, setProgress] = useState(0);

  useEffect(() => {
    let sourceFile: EleImage[] = [];
    if (!isEmpty(value)) {
      sourceFile = Array.isArray(value) ? value : [{ imageUrl: value }];
    }
    const defaultImages = sourceFile.filter((it) => it.imageUrl).map((it) => ({ url: it.imageUrl }));
    setFiles(defaultImages);
  }, [value]);

  const handleChange = (theFiles: EleAtImage[] = []) => {
    const images = theFiles.map((it) => ({ imageUrl: it.url }));
    onChange(images);
  };

  const uploadNewFiles = (currentFiles) => {
    const todoList = currentFiles.filter((it) => {
      const { url = '' } = it;
      return url.startsWith('http://tmp') || url.startsWith('wxfile://tmp');
    });

    const resetProgress = () => setProgress(0);
    const onProgress = ({ progress: progressValue }) => setProgress(progressValue);

    const onSuccess = (sourceFile, remoteFile) => {
      setFiles((preState) => {
        const tempList = preState.map((it) => {
          if (it.url === sourceFile) {
            return {
              url: remoteFile,
            };
          }
          return it;
        });
        handleChange(tempList);
        return tempList;
      });
    };

    const uploadFileOption = {
      todoList,
      onProgress,
      onStart: resetProgress,
      onComplete: resetProgress,
      onSuccess,
    };
    uploadFiles(uploadFileOption);
  };

  const handleFileChange = (changedFiles, operationType) => {
    console.log('the item disabled', disabled);
    if (disabled) {
      // noinspection JSIgnoredPromiseFromCall
      Taro.showModal({
        title: '提示',
        content: `该字段不可编辑`,
        showCancel: false,
      });
      return;
    }

    if (operationType === 'remove') {
      setFiles(changedFiles);
      handleChange(changedFiles);
      return;
    }

    if (operationType === 'add') {
      if (changedFiles.length < files.length || changedFiles.length <= maxLength) {
        setFiles(changedFiles);
        uploadNewFiles(changedFiles);
      } else {
        // noinspection JSIgnoredPromiseFromCall
        Taro.showModal({
          title: '提示',
          content: `最多可以上传 ${maxLength} 张图片`,
          showCancel: false,
        });
      }
      return;
    }
    console.error('未知操作');
  };

  // @ts-ignore
  const onImageClick = (index, file) => {
    // noinspection JSIgnoredPromiseFromCall
    Taro.previewImage({ urls: [file.url] });
  };

  const multiple = maxLength > 1;
  const briefText = brief || (multiple ? `最多可以上传 ${maxLength} 个文件` : '');
  const showAddBtn = files.length < maxLength;
  const count = maxLength - files.length;
  console.log('render image picker');

  return (
    <View>
      <AtImagePicker
        className='ele-image-picker-icon'
        count={count}
        length={4} //单行显示最大个数
        showAddBtn={showAddBtn}
        multiple={multiple}
        // @ts-ignore
        files={files}
        onChange={handleFileChange}
        onImageClick={onImageClick}
      />
      <Text className='note'>{briefText}</Text>
      {progress > 0 && <AtProgress percent={progress} />}
    </View>
  );
}

EleImagePicker.defaultProps = {
  brief: '',
  maxLength: 4,
  value: [],
  onChange: noop,
};

export default EleImagePicker;
