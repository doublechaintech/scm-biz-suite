

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './MemberRewardPoint.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (memberRewardPoint,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{memberRewardPoint.id}</Description> 
<Description term="名称">{memberRewardPoint.name}</Description> 
<Description term="点">{memberRewardPoint.point}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = memberRewardPoint => {
  const {MemberRewardPointBase} = GlobalComponents
  return <PermissionSetting targetObject={memberRewardPoint}  targetObjectMeta={MemberRewardPointBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class MemberRewardPointPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  memberRewardPoint = this.props.memberRewardPoint;
    const { id,displayName,  } = memberRewardPoint
    const cardsData = {cardsName:"会员奖励点",cardsFor: "memberRewardPoint",cardsSource: memberRewardPoint,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  memberRewardPoint: state._memberRewardPoint,
}))(Form.create()(MemberRewardPointPermission))

