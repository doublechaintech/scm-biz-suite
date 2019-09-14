

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
import styles from './GoodsMovement.profile.less'
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
const internalSummaryOf = (goodsMovement,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goodsMovement.id}</Description> 
<Description term="移动时间">{ moment(goodsMovement.moveTime).format('YYYY-MM-DD')}</Description> 
<Description term="设施">{goodsMovement.facility}</Description> 
<Description term="设备ID">{goodsMovement.facilityId}</Description> 
<Description term="从IP">{goodsMovement.fromIp}</Description> 
<Description term="会话ID">{goodsMovement.sessionId}</Description> 
<Description term="纬度">{goodsMovement.latitude}</Description> 
<Description term="经度">{goodsMovement.longitude}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = goodsMovement => {
  const {GoodsMovementBase} = GlobalComponents
  return <PermissionSetting targetObject={goodsMovement}  targetObjectMeta={GoodsMovementBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class GoodsMovementPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goodsMovement = this.props.goodsMovement
    const { id,displayName,  } = goodsMovement
    const  returnURL = `/goodsMovement/${id}/dashboard`
    const cardsData = {cardsName:"货物移动",cardsFor: "goodsMovement",cardsSource: goodsMovement,displayName,returnURL,
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
  goodsMovement: state._goodsMovement,
}))(Form.create()(GoodsMovementPermission))

