import { useEffect } from 'react';
import NavigationService from '@/nice-router/navigation-service';
import { View } from '@tarojs/components';

function TestPage() {
  useEffect(() => {
    NavigationService.view('mock-generic-page/');
  }, []);
  return <View />;
}

export default TestPage;
