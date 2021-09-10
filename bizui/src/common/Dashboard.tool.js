/* eslint-disable react/react-in-jsx-scope */
/* eslint-disable react/jsx-indent */
import PermissionSettingService from '../permission/PermissionSetting.service';
import {
  List,
  Row,
  Col,
  Icon,
  Card,
  Tooltip,
  Switch,
  Select,
  Form,
  Pagination,
  AutoComplete,
  Modal,
  Divider,
  Collapse,
  Tabs,
  Avatar,
  Menu,
} from 'antd';
import styles from './Dashboard.tool.less';
import ImagePreview from '../components/ImagePreview';
import Trend from '../components/Trend';
import numeral from 'numeral';
import { Link, Route, Redirect } from 'dva/router';
import ReactEcharts from 'echarts-for-react';
import moment from 'moment';
import appLocaleName from './Locale.tool';
const { SubMenu } = Menu;
import { ChartCard, MiniArea, MiniBar } from 'components/Charts';

import { PREFIX } from '../axios/tools';

import echarts from 'echarts';
import Themes from './Dashboard.echartstheme';

const { Panel } = Collapse;
//get more style from https://echarts.baidu.com/theme-builder/
echarts.registerTheme('bizTheme2', Themes.bizTheme);
//please do not use defaultTheme, this is a big trap for developers

const { hasItemCreatePermission, hasItemReadPermission } = PermissionSettingService;
const { Option } = Select;

const topColResponsiveProps = {
  xs: 8,
  sm: 8,
  md: 6,
  lg: 6,
  xl: 6,
  style: { marginBottom: 24, marginTop: 24 },
};

const calcLayoutForChartCard = count => {
  if (count === 1) {
    return { ...topColResponsiveProps, xs: 24, sm: 24, md: 24, lg: 24, xl: 24 };
  }
  if (count === 2) {
    return { ...topColResponsiveProps, xs: 12, sm: 12, md: 12, lg: 12, xl: 12 };
  }
  if (count === 3) {
    return { ...topColResponsiveProps, xs: 8, sm: 8, md: 8, lg: 8, xl: 8 };
  }

  return topColResponsiveProps;
};

const wholeLineColProps = {
  xs: 24,
  sm: 24,
  md: 24,
  lg: 24,
  xl: 24,
  style: { marginBottom: 24 },
};

const quckFunctionProps = {
  xs: 24,
  sm: 24,
  md: 12,
  lg: 6,
  xl: 6,
};

const renderForNumbers = aggregatedData => {
  if (!aggregatedData) {
    return null;
  }
  //scan all property ends with stats info

  const data = aggregatedData;
  if (!data.dataArray) {
    return null;
  }
  if (data.dataArray.length === 0) {
    return null;
  }
  // <MiniArea color="#975FE4" data={visitData} />

  const colors = [
    '#e6194b',
    '#3cb44b',
    '#ffe119',
    '#4363d8',
    '#f58231',
    '#911eb4',
    '#46f0f0',
    '#f032e6',
    '#bcf60c',
    '#fabebe',
    '#008080',
    '#e6beff',
    '#9a6324',
    '#fffac8',
    '#800000',
    '#aaffc3',
    '#808000',
    '#ffd8b1',
    '#000075',
    '#808080',
    '#ffffff',
    '#000000',
  ];
  let colorIndex = 0;
  return (
    <Row gutter={24}>
      {data.dimensions.map(item => {
        const visitData = [];
        let itemTotal = 0;
        const weekData = { lastWeek: 0, thisWeek: 0, lastWeekCount: 7, change: 0 };
        const chartCardLayout = topColResponsiveProps;
        data.dataArray
          .filter(dateItem => dateItem.date !== '未分配')
          .filter(dateItem => dateItem[item] > 0)
          .map(dateItem => {
            visitData.push({ x: dateItem.date, y: dateItem[item] });
            const weeknumber = moment(dateItem.date, 'YYYY/MM/DD').week();
            const thisweeknumber = moment().week();
            if (thisweeknumber - weeknumber === 1) {
              // last week
              weekData.lastWeek += dateItem[item];
            }
            if (thisweeknumber - weeknumber === 0) {
              // this week
              weekData.thisWeek += dateItem[item];
            }

            // console.log("week of the year for ", dateItem.date, " week number",weeknumber)
            itemTotal += dateItem[item];
          });

        if (itemTotal < 2) {
          return null;
        }
        /*
        if (visitData.length < 10) {
          return null;
        }*/
        let ChartComp = MiniArea;

        if (visitData.length < 10) {
          ChartComp = MiniBar;
        }
        colorIndex += 1;
        console.log('index: ', colorIndex, colors[colorIndex % colors.length]);

        const chartColor = colors[colorIndex % colors.length];

        const trend = target => {
          if (target.lastWeek === target.thisWeek) {
            return '';
          }

          return target.lastWeek > target.thisWeek ? 'down' : 'up';
        };
        const change = target => {
          if (target.thisWeek === 0 && target.lastWeek === 0) {
            return `-`;
          }
          if (target.thisWeek === 0) {
            return `100.00%`;
          }
          if (target.lastWeek === 0) {
            return 'NA';
          }
          const percent = ((target.thisWeek - target.lastWeek) / target.lastWeek) * 100;
          return `${numeral(Math.abs(percent)).format('0.00')}%`;
        };

        return (
          <Col key={item} {...chartCardLayout}>
            <ChartCard
              bordered={false}
              title={item}
              action={
                <Tooltip title="指标说明">
                  <Icon type="info-circle-o" />
                </Tooltip>
              }
              total={numeral(itemTotal).format('0,0')}
              footer={
                <div>
                  <Trend flag={trend(weekData)} style={{ marginRight: 16 }}>
                    上周: {numeral(weekData.lastWeek).format('0,0')}
                    /本周: {numeral(weekData.thisWeek).format('0,0')}
                    <span className={styles.trendText}>
                      环比
                      {change(weekData)}
                    </span>
                  </Trend>
                </div>
              }
              contentHeight={46}
            >
              <ChartComp color={chartColor} data={visitData} />
            </ChartCard>
          </Col>
        );
      })}
    </Row>
  );
};

const renderForTimeLine = aggregatedData => {
  if (!aggregatedData) {
    return null;
  }
  // scan all property ends with stats info
  console.log('aggregatedData', aggregatedData);

  const data = aggregatedData;
  if (!data.dataArray) {
    return null;
  }
  if (data.dataArray.length < 10) {
    return null;
  }
  const option = {
    legend: {},
    toolbox: {
      show: true,
      orient: 'vertical',
      feature: {
        dataZoom: {
          yAxisIndex: 'none',
        },
        dataView: { readOnly: false },
        magicType: { type: ['line', 'bar'] },
        restore: {},
        saveAsImage: {},
      },
    },
    tooltip: {
      trigger: 'axis',
    },
    dataset: {
      dimensions: data.dimensions,
      source: data.dataArray,
    },

    xAxis: { type: 'category' },
    yAxis: {},
    dataZoom: [
      {
        type: 'slider',
        show: true,
        xAxisIndex: [0],
        start: 0,
        end: 100,
      },
    ],

    series: data.series,
  };

  const click = event => {
    console.log('clicked', event);
  };
  const datazoom = event => {
    console.log('datazoomed', event);
  };
  const legend = event => {
    console.log('legend', event);
  };
  const onEvents = { click: click, legendselectchanged: legend, datazoom: datazoom };

  return (
    <Card>
      <ReactEcharts
        option={option}
        height={600}
        theme="bizTheme2"
        style={{ height: '400px' }}
        onEvents={onEvents}
      />
    </Card>
  );
};

Set.prototype.toArray = function() {
  const result = [];

  this.forEach((value, v, set) => {
    result.push(value);
  });
  return result;
};

const calcKey = item => {
  if (!item) {
    return '未知';
  }
  if (!item.key) {
    return '没有标题';
  }
  if (item.key.id == null) {
    return '未分配';
  }
  if (item.key.displayName) {
    return item.key.displayName;
  }
  if (item.key.id) {
    return item.key.id;
  }
  return '未分配';
};

const aggregateDataset = mainObject => {
  const dataMap = {};
  const dimensionSet = new Set(['date']);
  for (const key in mainObject) {
    if (!key.endsWith('StatsInfo')) {
      continue;
    }
    const statsInfo = mainObject[key];
    if (!statsInfo) {
      continue;
    }
    const series = statsInfo.itemList.find(item => item.internalName.endsWith('OfDateline'));
    if (!series) {
      continue;
    }
    series.result.map(item => {
      const itemkey = calcKey(item);
      const existedValue = dataMap[itemkey];
      const itemValue = {};
      const { displayName } = series;
      itemValue[displayName] = item.count;
      dimensionSet.add(displayName);
      if (!existedValue) {
        dataMap[itemkey] = { date: itemkey, ...itemValue };
        return;
      }
      dataMap[itemkey] = { ...existedValue, ...itemValue };
    });
  }

  const dimensions = dimensionSet.toArray();
  const defaultEntry = {};
  const filteredDimensions = dimensions.filter(item => item != 'date').map(item => {
    defaultEntry[item] = 0;
  });
  console.log('default entry', defaultEntry);
  console.log('default dimensions', dimensions);
  const dataArray = Object.entries(dataMap)
    .map(([key, value]) => ({ ...defaultEntry, ...value }))
    .sort((a, b) => a.date.localeCompare(b.date, 'zh-CN'));
  console.log('default dataArray', dataArray);
  // I want to add it in the theme file, but failed to do that
  const itemStyle = {
    normal: {
      lineStyle: {
        width: 3, // 0.1的线条是非常细的了
      },
    },
  };

  const markPoint = {
    data: [{ type: 'max', name: '最大值' }],
  };

  const series = filteredDimensions.map(item => ({
    type: 'line',
    stack: '总量',
    symbolSize: '2',
    symbol: 'circle',
    smooth: true,
    areaStyle: {},
    markPoint,
    itemStyle,
  }));
  return { dimensions, series, dataArray };
};

const defaultImageListOf = (mainObject, imageList) => {
  const filteredList = imageList(mainObject).filter(item => item.imageLocation != null);
  if (filteredList.length === 0) {
    return null;
  }

  return (
    <Card title="图片列表" className={styles.card}>
      <Row type="flex" justify="start" align="bottom">
        {filteredList.map((item, index) => (
          <Col span={24} key={index}>
            <ImagePreview
              imageTitle={item.title}
              imageStyle={{ width: '100%' }}
              showTitleUnderImage={true}
              imageLocation={item.imageLocation}
            >
              {item.title}
            </ImagePreview>
          </Col>
        ))}
      </Row>
    </Card>
  );
};

const defaultSettingListOf = (mainObject, optionList) => {
  const resultList = optionList(mainObject);
  if (resultList.length === 0) {
    return null;
  }
  return (
    <Card title="状态集合" className={styles.card}>
      {resultList.map(item => (
        <Col key={item.parameterName} span={6} style={{ height: '60px' }}>
          <Switch
            title={item.title}
            checked={item.value}
            type={item.value ? 'success' : 'error'}
            checkedChildren="是"
            unCheckedChildren="否"
          />
          <span style={{ margin: '10px' }}>{item.title}</span>
        </Col>
      ))}
    </Card>
  );
};

const defaultLargeTextOf = mainObject => {
  return null;
};

/////////////////////////////////////// BUILD FOR TRANSFERRING TO ANOTHER OBJECT////////////////////////////////////////////////
//TODO: repalce with service
const defaultHandleTransferSearch = (targetComponent, filterKey, newRequest) => {
  const parameters = newRequest || targetComponent.state;

  const {
    candidateServiceFunc,
    candidateObjectType,
    targetLocalName,
    transferServiceFunc,
  } = parameters;

  const id = ''; //not used for now
  const pageNo = 1;
  const candidateReferenceService = candidateServiceFunc;
  if (!candidateReferenceService) {
    console.log('candidateReferenceService current state, not working', parameters);
    return;
  }
  // get a function for fetching the candidate reference list
  const future = candidateReferenceService(candidateObjectType, id, filterKey, pageNo);

  future.then(candidateReferenceList => {
    targetComponent.setState({
      ...parameters,
      candidateReferenceList,
      transferModalVisiable: true,
      transferModalTitle: '重新分配<' + targetLocalName + '>',
    });
  });
};
//  onClick={()=>showTransferModel(targetComponent,"城市","city","requestCandidateDistrict","transferToAnotherDistrict")}

const defaultExecuteTrans = (mainObject, targetComponent) => {
  const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = targetComponent.props.form;
  const {
    candidateServiceFunc,
    candidateObjectType,
    targetLocalName,
    transferServiceFunc,
    defaultType,
  } = targetComponent.state;

  const { dispatch } = targetComponent.props;

  validateFieldsAndScroll((error, values) => {
    console.log('error', values);

    const parameters = { ...values };
    const id = mainObject.id;
    const serviceNameToCall = transferServiceFunc;
    console.log('service to call ', serviceNameToCall);
    const payload = { parameters, id, serviceNameToCall };

    //targetComponent.setState({transferModalVisiable:false})
    dispatch({ type: `_${defaultType}/doJob`, payload: payload });

    targetComponent.setState({ transferModalVisiable: false });
  });
};

const defaultShowTransferModel = (
  targetComponent,
  targetLocalName,
  candidateObjectType,
  candidateServiceFunc,
  transferServiceFunc,
  transferTargetParameterName,
  currentValue
) => {
  const filterKey = '';

  const newRequest = {
    targetLocalName,
    candidateObjectType,
    candidateServiceFunc,
    transferServiceFunc,
    transferTargetParameterName,
    currentValue,
  };
  console.log('showTransferModel  new state', newRequest);
  //targetComponent.setState(newState);
  defaultHandleTransferSearch(targetComponent, filterKey, newRequest);
};

const defaultBuildTransferModal = (mainObject, targetComponent) => {
  const {
    transferModalVisiable,
    targetLocalName,
    transferModalTitle,
    candidateReferenceList,
    transferTargetParameterName,
    currentValue,
  } = targetComponent.state;
  const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = targetComponent.props.form;

  if (!candidateReferenceList || !candidateReferenceList.candidates) {
    return null;
  }

  const formItemLayout = {
    labelCol: { span: 8 },
    wrapperCol: { span: 16 },
  };

  const list = candidateReferenceList.candidates;
  console.log('the list is ', list);

  return (
    <Modal
      title={transferModalTitle}
      visible={transferModalVisiable}
      onOk={() => defaultExecuteTrans(mainObject, targetComponent)}
      onCancel={() => defaultHideCloseTrans(targetComponent)}
    >
      <Form>
        <Row gutter={16}>
          <Col lg={24} md={24} sm={24}>
            <Form.Item label={`请选择新的${targetLocalName}`} {...formItemLayout}>
              {getFieldDecorator(transferTargetParameterName, {
                rules: [{ required: true, message: '请搜索' }],
                initialValue: currentValue,
              })(
                <AutoComplete
                  dataSource={list}
                  onSearch={value => defaultHandleTransferSearch(targetComponent, value)}
                >
                  {list.map((item, index) => {
                    return <Option key={item.id}>{`${item.displayName}(${item.id})`}</Option>;
                  })}
                </AutoComplete>
              )}
            </Form.Item>
          </Col>
        </Row>
      </Form>
    </Modal>
  );
};

const renderFunctions = mainObject => {
  if (!mainObject) {
    return null;
  }
  if (!mainObject.actionList) {
    return null;
  }
  const actionList = mainObject.actionList.filter(item => item.actionGroup === 'changerequesttype');
  // const actionList = platform.actionList

  if (!actionList) {
    return null;
  }
  if (actionList.length === 0) {
    return null;
  }

  return (
    <List
      grid={{ gutter: 16, column: 6 }}
      dataSource={actionList}
      styles={{ backgroundColor: 'white' }}
      renderItem={item => (
        <List.Item>
          <Card className={styles.crCard}>
            <Link to={item.actionPath}>
              <Icon type={item.actionIcon} style={{ fontSize: 20, color: 'orange' }} />
            </Link>
            <br />
            <br />
            {item.actionName}
          </Card>
        </List.Item>
      )}
    />
  );
};

const defaultRenderExtraHeader = mainObject => {
  return <div>{renderFunctions(mainObject)} </div>;
};

const defaultRenderAnalytics = mainObject => {
  const data = aggregateDataset(mainObject);
  if (!data.dataArray) {
    return null;
  }
  if (data.dataArray.length === 0) {
    return null;
  }
  // {renderForTimeLine(data)}
  return <div>{renderForNumbers(data)}</div>;
};

const legalListForDisplay = (targetObject, listItem) => {
  if (!targetObject) {
    return false;
  }
  if (!listItem) {
    return false;
  }
  if (!listItem.name) {
    return false;
  }
  if (!targetObject[listItem.name]) {
    return false;
  }

  return true;
};
const defaultRenderSubjectList2 = cardsData => {
  // listItem.renderItem(item)
  const targetObject = cardsData.cardsSource;
  return (
    <Row gutter={16}>
      {cardsData.subItems

        .filter(listItem => legalListForDisplay(targetObject, listItem))
        .map(listItem => (
          <Col key={listItem.displayName} span={24} {...wholeLineColProps}>
            <Card title={listItem.displayName} style={{ marginBottom: 24 }}>
              {targetObject[listItem.name].map(item => listItem.renderItem(item))}
            </Card>
          </Col>
        ))}
    </Row>
  );
};

const defaultRenderSubjectList = cardsData => {
  // listItem.renderItem(item)
  const targetObject = cardsData.cardsSource;
  const { TabPane } = Tabs;
  function callback(key) {
    console.log(key);
  }

  if (!cardsData.subItems.length) {
    return null;
  }

  if (cardsData.subItems.length === 0) {
    return null;
  }

  return (
    <Tabs onChange={callback}>
      {cardsData.subItems

        .filter(listItem => legalListForDisplay(targetObject, listItem))
        .map(listItem => (
          <TabPane
            tab={listItem.displayName}
            key={listItem.displayName}
            style={{ backgroundColor: 'lightgrey' }}
          >
            {targetObject[listItem.name].map(item =>
              listItem.renderItem(item, targetObject, 6, listItem.name)
            )}
          </TabPane>
        ))}
    </Tabs>
  );
};

const defaultRenderSubjectList4 = cardsData => {
  // listItem.renderItem(item)
  const targetObject = cardsData.cardsSource;
  const { TabPane } = Tabs;
  function callback(key) {
    console.log(key);
  }
  if (!cardsData || !cardsData.subItems) {
    return null;
  }
  const listWithDataLength = cardsData.subItems.filter(item => item.count > 0).length;
  if (listWithDataLength > 10) {
    return null;
  }

  return (
    <Row gutter={16}>
      {cardsData.subItems

        .filter(listItem => legalListForDisplay(targetObject, listItem))
        .map(listItem => (
          <Col key={listItem.displayName} {...wholeLineColProps}>
            <Card title={listItem.displayName} style={{ marginBottom: 24 }}>
              {targetObject[listItem.name].map(item => listItem.renderItem(item))}
            </Card>
          </Col>
        ))}
    </Row>
  );
};

const defaultRenderExtraFooter = mainObject => {
  return null;
};
const defaultSubListsOf = cardsData => {
  const userContext = null;
  const { id } = cardsData.cardsSource;
  return (
    <Row gutter={24}>
      {cardsData.subItems
        .sort((x, y) => x.displayName.localeCompare(y.displayName, 'zh-CN'))
        .filter(item => hasItemReadPermission(item))
        .map(item => (
          <Col {...topColResponsiveProps} key={item.name}>
            <Card
              title={
                <span>
                  <Link
                    to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}
                  >
                    {item.displayName}({numeral(item.count).format('0,0')})
                  </Link>
                  {hasItemCreatePermission(item) && (
                    <Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}>
                      <span className={styles.splitLine} />
                      <Icon type="plus" />
                      {appLocaleName(userContext, 'Add')}
                    </Link>
                  )}
                </span>
              }
            >
              <p />
            </Card>
          </Col>
        ))}
    </Row>
  );
};

const defaultQuickFunctions3 = cardsData => {
  const { id, actionList } = cardsData.cardsSource;
  return (
    <Row gutter={16}>
      {actionList &&
        actionList.filter(item => item.actionGroup === 'custom').map(item => (
          <Col {...quckFunctionProps} key={`${item.actionPath}`}>
            <Card style={{ fontSize: '20px' }}>
              <a href={`${PREFIX}${item.managerBeanName}/${item.actionPath}`} target="_blank">
                <Icon type={item.actionIcon} /> {item.actionName}
              </a>
            </Card>
          </Col>
        ))}
      {cardsData &&
        cardsData.subItems &&
        cardsData.subItems.filter(item => hasItemReadPermission(item)).map(item => (
          <Col key={item.displayName} {...quckFunctionProps}>
            <Card span={6} style={{ fontSize: '20px' }}>
              <Row gutter={16}>
                {hasItemCreatePermission(item) && (
                  <Col span={3}>
                    <Tooltip title={`增加一个${item.displayName}`} placement="bottom">
                      <Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}>
                        <Icon type="plus" />
                      </Link>
                    </Tooltip>
                  </Col>
                )}

                <Col span={21}>
                  <Tooltip title={`进入${item.displayName}列表`} placement="bottom">
                    <Link
                      to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}
                    >
                      {item.displayName} 111
                    </Link>
                    <span style={{ fontSize: '10px' }}> 共{item.count}条</span>
                  </Tooltip>
                </Col>
              </Row>
            </Card>
          </Col>
        ))}
    </Row>
  );
};

const groupMenuOf = cardsData => {
  const groupedItems = [];
  cardsData.subItems.filter(item => hasItemReadPermission(item)).map(item => {
    const { viewGroup } = item;
    let result = groupedItems.find(viewGroupItem => viewGroupItem.viewGroup === viewGroup);

    if (!result) {
      // group not found
      result = { viewGroup, subItems: [] };
      groupedItems.push(result);
    }
    const { subItems } = result;
    subItems.push(item);
  });
  return groupedItems;
};

const keepShort = (value, length) => {
  if (value.length <= length) {
    return value;
  }
  return `${value.substring(0, length - 1)}..`;
};
const showNumber = item => {
  if (!item.count) {
    return '';
  }
  return `(${item.count})`;
};
const functionItem = (cardsData, item) => {
  const { id } = cardsData.cardsSource;

  console.log('item.displayName', item.displayName);

  return (
    <Col key={item.displayName} span={4} className={styles.functionItem}>
      <Tooltip title={`进入${item.displayName}列表${showNumber(item)}`} placement="bottom">
        <Link
          style={{ fontSize: '14px' }}
          to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}
        >
          {keepShort(item.displayName,6)}
        </Link>
      </Tooltip>
    </Col>
  );
};

const fixName = name => {
  if (!name) {
    return '常用功能';
  }
  if (name === '' || name === '__no_group') {
    return '常用功能';
  }
  return name;
};

const viewGroupName = name => {
  return <span style={{ fontSize: '20px', fontWeight: 'bolder' }}>{fixName(name)}</span>;
};

const viewGroupTitle = item => {
  return (
    <span style={{ fontWeight: 'bolder', textAlign: 'center' }}>{fixName(item.viewGroup)}</span>
  );
};

const CustomFunction = cardsData => {
  const { actionList } = cardsData.cardsSource;
  if (
    !actionList ||
    actionList.length === 0 ||
    actionList.filter(item => item.actionGroup === 'custom').length === 0
  ) {
    return null;
  }
  return (
    <Row key="__custom" gutter={16} className={styles.functionRow}>
      <Card span={6} style={{ fontSize: '14px' }}>
        <Col span={3} className={styles.functionItem}>
          特别功能
        </Col>

        <Col span={21}>
          {actionList.filter(item => item.actionGroup === 'custom').map(item => (
            <Col
              span={4}
              key={`${item.actionPath}`}
              style={{ marginTop: '5px', marginBotton: '5px' }}
            >
              <a href={`${PREFIX}${item.managerBeanName}/${item.actionPath}`} target="_blank">
                {item.actionName}
              </a>
            </Col>
          ))}
        </Col>
      </Card>
    </Row>
  );
};

const defaultQuickFunctions4 = cardsData => {
  return (
    <div style={{ marginLeft: '-28px', marginRight: '-28px' }}>
      {CustomFunction(cardsData)}
      {groupMenuOf(cardsData).map(groupItem => (
        <Row key={groupItem.viewGroup} gutter={16} className={styles.functionRow}>
          <Card span={6} style={{ fontSize: '14px' }}>
            <Col span={3} style={{ textColor: 'grey', marginTop: '5px', marginBotton: '5px' }}>
              {viewGroupName(groupItem.viewGroup)}
            </Col>
            <Col span={21}>{groupItem.subItems.map(item => functionItem(cardsData, item))}</Col>
          </Card>
        </Row>
      ))}
    </div>
  );
};

const groupBy = function(xs, key) {
  return xs.reduce(function(rv, x) {
    (rv[x[key]] = rv[x[key]] || []).push(x);
    return rv;
  }, {});
};

const prepareGroupedActionList = mainObject => {
  if (!mainObject) {
    return null;
  }
  if (!mainObject.actionList) {
    return null;
  }
  const actionList = mainObject.actionList.filter(item => item.actionGroup === 'changerequesttype');
  // const actionList = platform.actionList

  if (!actionList) {
    return null;
  }
  if (actionList.length === 0) {
    return null;
  }

  return groupBy(actionList, 'group');
};


const buildIcon=(item)=>{

  if(item.actionIcon.indexOf(".svg")>0){

    return <img src={`./icons/${item.actionIcon}`} width="40" height="40"/>

  }
  return (<Icon type={item.actionIcon} style={{ fontSize: 32, color: 'green' }} />)




}

const buildActionList = (actionList, groupName) => {
  console.log('buildActionList actionList', actionList, groupName);

  if (actionList == null) {
    return null;
  }
  
  return (
    <List
      grid={{ gutter: 16, column: 6 }}
      dataSource={actionList}
      styles={{ backgroundColor: 'white' }}
      renderItem={item => (
        <List.Item>
          <Card className={styles.crCard} style={{border:"0px"}}>
            <Link to={item.actionPath} title={item.actionName}>
              <div className={styles.crCard.icon}>{buildIcon(item)}</div>
            </Link>
           
            <span className={styles.crCard.shortText} >{keepShort(item.actionName,4)}</span>
           
          </Card>
        </List.Item>
      )}
    />
  );
};

const buildGroupedActionList = (groupedActionList, groupName) => {
  console.log('buildGroupedActionList', groupedActionList, groupName);

  if (groupedActionList == null) {
    return null;
  }

  if (!groupedActionList[groupName]) {
    return null;
  }

  return buildActionList(groupedActionList[groupName], groupName);
};

const colorList = ['#f56a00', '#7265e6', '#ffbf00', 'green'];
let counter = 0;
const genColor = () => {
  counter++;
  return colorList[counter % colorList.length];
};

const viewGroupAvatar = text => {
  return (
    <Avatar size={90} style={{ color: 'white', backgroundColor: genColor(), fontSize: '40px' }}>
      {text.substring(0, 1)}
    </Avatar>
  );
};

const mergeGroupItem = cardsData => {
  const groupedActionList = prepareGroupedActionList(cardsData.cardsSource);
  return groupMenuOf(cardsData).map(groupItem => {
    if (groupedActionList && groupedActionList[groupItem.viewGroup]) {
      groupItem.subActionList = groupedActionList[groupItem.viewGroup];
    }

    return groupItem;
  });
};
//Object.entries
const orphanGroupItemList = cardsData => {
  const groupedActionList = prepareGroupedActionList(cardsData.cardsSource);
  groupMenuOf(cardsData).map(groupItem => {
    if (groupedActionList && groupedActionList[groupItem.viewGroup]) {
      //groupItem.subActionList=groupedActionList[groupItem.viewGroup]
      delete groupedActionList[groupItem.viewGroup];
    }
  });

  return groupedActionList;
};

const defaultQuickFunctions = cardsData => {
  const groupedActionList = prepareGroupedActionList(cardsData.cardsSource);
  const orphanGroupItems = orphanGroupItemList(cardsData);

  console.log('groupedActionList', groupedActionList);
  console.log('orphanGroupItems', orphanGroupItems);

  return (
    <div>
      {CustomFunction(cardsData)}

      {orphanGroupItems &&
        Object.entries(orphanGroupItems).map(([viewGroupName, actionList]) => (
          <Row key={viewGroupName} gutter={16} className={styles.functionRow}>
            <Card span={6} style={{ fontSize: '14px' }}>
              <Col span={3} style={{ textColor: 'grey', marginTop: '5px', marginBotton: '5px' }}>
                {viewGroupAvatar(viewGroupName)}
              </Col>
              <Col span={21}>{buildActionList(actionList, viewGroupName)}</Col>
            </Card>
          </Row>
        ))}

      {mergeGroupItem(cardsData).map(groupItem => (
        <Row key={groupItem.viewGroup} gutter={16} className={styles.functionRow}>
          <Card span={6} style={{ fontSize: '14px' }}>
            <Col span={3} style={{ textColor: 'grey', marginTop: '5px', marginBotton: '5px' }}>
              {viewGroupName(groupItem.viewGroup)}
            </Col>
            <Col span={21}>{groupItem.subItems.map(item => functionItem(cardsData, item))}</Col>
          </Card>

          {groupedActionList &&
            groupedActionList[groupItem.viewGroup] && (
              <Card span={6} style={{ fontSize: '14px' }}>
                <Col
                  span={3}
                  style={{
                    textColor: 'grey',
                    marginTop: '5px',
                    marginBotton: '5px',
                    alignItems: 'center',
                  }}
                >
                  {viewGroupAvatar(groupItem.viewGroup)}
                </Col>

                <Col span={21}>{buildActionList(groupItem.subActionList, groupItem.viewGroup)}</Col>
              </Card>
            )}
        </Row>
      ))}
    </div>
  );
};

const defaultQuickFunctions1 = cardsData => {
  //style={{marginLeft: '-28px',marginRight:'-28px'}}

  return (
    <Menu
      mode="horizontal"
      style={{ marginLeft: '-28px', marginRight: '-28px', paddingLeft: '20px' }}
    >
      {groupMenuOf(cardsData).map(groupItem => (
        <SubMenu
          key={groupItem.viewGroup}
          title={viewGroupTitle(groupItem)}
          style={{ margin: '0px 10px 0px 10px' }}
        >
          {groupItem.subItems.map(item => (
            <Menu.Item key={item}>{functionItem(cardsData, item)}</Menu.Item>
          ))}
        </SubMenu>
      ))}
    </Menu>
  );
};

const defaultHideCloseTrans = targetComponent => {
  targetComponent.setState({ transferModalVisiable: false });
};

const renderTitle = (listItem, cardsData) => {
  const { id } = cardsData.cardsSource;
  return (
    <div>
      {listItem.displayName}({listItem.count})
      <Link to={`/${cardsData.cardsFor}/${id}/list/${listItem.name}/${listItem.displayName}列表`}>
        <Icon type="double-right" />
      </Link>
    </div>
  );
};

const renderListContent = (targetObject, listItem) => {
  const listContent = targetObject[listItem.name];
  if (!listContent) {
    return <div>稍等...</div>;
  }
  return listContent.map(item => listItem.renderItem(item));
};
const defaultRenderSettingList = cardsData => {
  // listItem.renderItem(item)
  const targetObject = cardsData.cardsSource;

  return (
    <Collapse bordered={false} defaultActiveKey={['1']}>
      {cardsData.subItems.map(listItem => (
        <Panel header={renderTitle(listItem, cardsData)} key={listItem.name}>
          {renderListContent(targetObject, listItem, cardsData)}
        </Panel>
      ))}
    </Collapse>
  );
};

const DashboardTool = {
  aggregateDataset,
  calcKey,
  defaultHideCloseTrans,
  defaultImageListOf,
  defaultSettingListOf,
  defaultBuildTransferModal,
  defaultExecuteTrans,
  defaultHandleTransferSearch,
  defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultRenderAnalytics,
  defaultSubListsOf,
  defaultRenderExtraFooter,
  renderForTimeLine,
  renderForNumbers,
  defaultQuickFunctions,
  defaultRenderSubjectList,
  defaultRenderSettingList,
};

export default DashboardTool;
