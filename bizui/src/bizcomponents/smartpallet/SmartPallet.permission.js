

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
import styles from './SmartPallet.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (smartPallet,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{smartPallet.id}</Description> 
<Description term="Location">{smartPallet.location}</Description> 
<Description term="Contact Number">{smartPallet.contactNumber}</Description> 
<Description term="Total Area">{smartPallet.totalArea}</Description> 
<Description term="Latitude">{smartPallet.latitude}</Description> 
<Description term="Longitude">{smartPallet.longitude}</Description> 
<Description term="Last Update Time">{ moment(smartPallet.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = smartPallet => {
  const {SmartPalletBase} = GlobalComponents
  return <PermissionSetting targetObject={smartPallet}  targetObjectMeta={SmartPalletBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SmartPalletPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  smartPallet = this.props.smartPallet;
    const { id,displayName, goodsCount } = smartPallet
    const cardsData = {cardsName:"Smart Pallet",cardsFor: "smartPallet",cardsSource: smartPallet,
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
  smartPallet: state._smartPallet,
}))(Form.create()(SmartPalletPermission))

