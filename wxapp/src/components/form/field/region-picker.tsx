import { useEffect, useState } from 'react';
import StorageTools from '@/nice-router/storage-tools';
import NavigationService from '@/nice-router/navigation-service';
import ElePicker, { ElePickerProps } from '@/components/form/field/ele-picker';
import { isNotEmpty } from '@/nice-router/nice-router-util';

function RegionPicker(props: ElePickerProps) {
  const [source, setSource] = useState([]);

  useEffect(() => {
    const regionData = StorageTools.get('region-data', null);
    let initialed = false;
    if (isNotEmpty(regionData)) {
      setSource(regionData);
      initialed = true;
    }

    NavigationService.ajax(
      'wxappService/makeRegionList/',
      {},
      {
        onSuccess: (resp) => {
          if (!initialed) {
            setSource(resp);
          }
          StorageTools.set('region-data', resp, 3600);
        },
      }
    );
  }, []);

  return <ElePicker {...props} candidateValues={source} />;
}

export default RegionPicker;
