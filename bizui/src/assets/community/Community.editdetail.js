

import React, { Component } from 'react';
import { connect } from 'dva';
import { Form,Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown } from 'antd';
import { Link, Route, Redirect, Switch } from 'dva/router';
import numeral from 'numeral';
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts';
import Trend from '../../components/Trend';
import NumberInfo from '../../components/NumberInfo';
import { getTimeDistance } from '../../utils/utils';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import styles from './Community.editdetail.less';
import InvitationCodeEditTable from '../invitationcode/InvitationCode.edittable'
const { TabPane } = Tabs;
const { RangePicker } = DatePicker;

const topColResponsiveProps = {
  xs: 24,
  sm: 12,
  md: 12,
  lg: 12,
  xl: 6,
  style: { marginBottom: 24 },
};


@connect(state => ({
  community: state._community,
}))
export default class CommunityEditDetail extends Component {


  
  render() {
    // eslint-disable-next-line max-len

    console.log("invitationcodelist", this.props.community)
    
    const { id, invitationCodeCount,invitationCodeList,
      homePageCount,
      encyclopediaItemCount,taskPageCount,communityUserCount,taskCount,groupPageCount,threadCount} = this.props.community;
    console.log("invitationcodelist", invitationCodeList)
    const owner = { type: '_community', id};
    if(!invitationCodeList){
      return null;
    }

    return (

      <PageHeaderLayout
        title="社区总览"
        content="社区总览"
        wrapperClassName={styles.advancedForm}
      >

        <Card title="邀请码列表" className={styles.card} bordered={false}>
        <Form layout="vertical" hideRequiredMark>
        <InvitationCodeEditTable data={invitationCodeList} owner={owner} />
       </Form>
        </Card>
        
      </PageHeaderLayout>
    );
  }
}



