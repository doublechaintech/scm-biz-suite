import React from 'react';
import { View } from '@tarojs/components';
import _ from 'lodash';
import './skeleton.scss';

type SkeletonProps = {
  loading: boolean;
  size: number;
  children?: React.ReactNode;
};

export default function Skeleton(props: SkeletonProps) {
  const { loading = false, size = 8 } = props;
  return (
    <View>
      {loading && (
        <View className='skeleton-list'>
          {_.times(size, (it) => {
            return (
              <View key={`skeleton-${it}`} className='skeleton-list-item'>
                <View className='skeleton-list-item-left' />
                <View className='skeleton-list-item-right'>
                  <View className='skeleton-list-item-right-title' />
                  <View className='skeleton-list-item-right-brief' />
                </View>
              </View>
            );
          })}
        </View>
      )}
      {props.children}
    </View>
  );
}
