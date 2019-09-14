

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreMemberCoupon.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (retailStoreMemberCoupon,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreMemberCoupon.id}</Description> 
<Description term="名称">{retailStoreMemberCoupon.name}</Description> 
<Description term="数">{retailStoreMemberCoupon.number}</Description> 
<Description term="最后更新时间">{ moment(retailStoreMemberCoupon.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreMemberCoupon => {
  const {RetailStoreMemberCouponBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreMemberCoupon}  targetObjectMeta={RetailStoreMemberCouponBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreMemberCouponPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreMemberCoupon = this.props.retailStoreMemberCoupon
    const { id,displayName,  } = retailStoreMemberCoupon
    const  returnURL = `/retailStoreMemberCoupon/${id}/dashboard`
    const cardsData = {cardsName:"生超会员优惠券",cardsFor: "retailStoreMemberCoupon",cardsSource: retailStoreMemberCoupon,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
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
  retailStoreMemberCoupon: state._retailStoreMemberCoupon,
}))(Form.create()(RetailStoreMemberCouponPermission))

