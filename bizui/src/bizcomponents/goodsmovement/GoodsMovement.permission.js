

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
import styles from './GoodsMovement.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (goodsMovement,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{goodsMovement.id}</Description> 
<Description term="Move Time">{ moment(goodsMovement.moveTime).format('YYYY-MM-DD')}</Description> 
<Description term="Facility">{goodsMovement.facility}</Description> 
<Description term="Facility Id">{goodsMovement.facilityId}</Description> 
<Description term="From Ip">{goodsMovement.fromIp}</Description> 
<Description term="Session Id">{goodsMovement.sessionId}</Description> 
<Description term="Latitude">{goodsMovement.latitude}</Description> 
<Description term="Longitude">{goodsMovement.longitude}</Description> 
	
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
    const  goodsMovement = this.props.goodsMovement;
    const { id,displayName,  } = goodsMovement
    const cardsData = {cardsName:"Goods Movement",cardsFor: "goodsMovement",cardsSource: goodsMovement,
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
  goodsMovement: state._goodsMovement,
}))(Form.create()(GoodsMovementPermission))

