

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
import styles from './SupplyOrderShipment.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (supplyOrderShipment,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{supplyOrderShipment.id}</Description> 
<Description term="Who">{supplyOrderShipment.who}</Description> 
<Description term="Ship Time">{ moment(supplyOrderShipment.shipTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = supplyOrderShipment => {
  const {SupplyOrderShipmentBase} = GlobalComponents
  return <PermissionSetting targetObject={supplyOrderShipment}  targetObjectMeta={SupplyOrderShipmentBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SupplyOrderShipmentPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplyOrderShipment = this.props.supplyOrderShipment;
    const { id,displayName, consumerOrderCount, supplyOrderCount } = supplyOrderShipment
    const cardsData = {cardsName:"Supply Order Shipment",cardsFor: "supplyOrderShipment",cardsSource: supplyOrderShipment,
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
  supplyOrderShipment: state._supplyOrderShipment,
}))(Form.create()(SupplyOrderShipmentPermission))

