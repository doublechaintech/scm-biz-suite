

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './RetailStoreMember.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (retailStoreMember,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreMember.id}</Description> 
<Description term="名称">{retailStoreMember.name}</Description> 
<Description term="移动电话">{retailStoreMember.mobilePhone}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = retailStoreMember => {
  const {RetailStoreMemberBase} = GlobalComponents
  return <PermissionSetting targetObject={retailStoreMember}  targetObjectMeta={RetailStoreMemberBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class RetailStoreMemberPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  retailStoreMember = this.props.retailStoreMember
    const { id,displayName, consumerOrderCount, retailStoreMemberCouponCount, memberWishlistCount, memberRewardPointCount, memberRewardPointRedemptionCount, retailStoreMemberAddressCount, retailStoreMemberGiftCardCount } = retailStoreMember
    const  returnURL = `/retailStoreMember/${id}/dashboard`
    const cardsData = {cardsName:"生超会员",cardsFor: "retailStoreMember",cardsSource: retailStoreMember,displayName,returnURL,
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
  retailStoreMember: state._retailStoreMember,
}))(Form.create()(RetailStoreMemberPermission))

