import { View } from '@tarojs/components';
import ActionFloorItem from './action-floor-item';

import './action-floor.scss';
import { ActionListLike } from '@/nice-router/nice-router-types';

function ActionFloor(props: ActionListLike) {
  const { actionList } = props || {};
  if (actionList.length === 0) {
    return null;
  }

  let list = actionList;
  if (actionList.length >= 3) {
    const t1 = actionList[3];
    const t2 = actionList[4];
    list = [t1, t2].concat(actionList);
  }

  const action1 = list[0];
  const action2 = list[1];
  const action3 = list[2];
  const action4 = list[3];
  const action5 = list[4];
  console.log('list', list);

  return (
    <View className='action-floor'>
      {action3 && (
        <View className='action-floor-first'>
          <View className='action-floor-first-left'>
            <View className='action-floor-item-container'>
              <ActionFloorItem {...action3} />
            </View>
          </View>

          <View className='action-floor-first-right'>
            <View className='action-floor-first-right-top'>
              <View className='action-floor-item-container'>
                <ActionFloorItem {...action4} />
              </View>
            </View>
            <View className='action-floor-first-right-bottom'>
              <View className='action-floor-item-container'>
                <ActionFloorItem {...action5} />
              </View>
            </View>
          </View>
        </View>
      )}
      {action1 && (
        <View className='action-floor-second'>
          <View className='action-floor-second-left'>
            <View className='action-floor-item-container'>
              <ActionFloorItem color='blue' {...action1} />
            </View>
          </View>

          {action2 && (
            <View className='action-floor-second-right'>
              <View className='action-floor-item-container'>
                <ActionFloorItem color='blue' {...action2} />
              </View>
            </View>
          )}
        </View>
      )}
    </View>
  );
}

export default ActionFloor;
