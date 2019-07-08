

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
import styles from './TransportTruck.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (transportTruck,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{transportTruck.id}</Description> 
<Description term="Name">{transportTruck.name}</Description> 
<Description term="Plate Number">{transportTruck.plateNumber}</Description> 
<Description term="Contact Number">{transportTruck.contactNumber}</Description> 
<Description term="Vehicle License Number">{transportTruck.vehicleLicenseNumber}</Description> 
<Description term="Engine Number">{transportTruck.engineNumber}</Description> 
<Description term="Make Date">{ moment(transportTruck.makeDate).format('YYYY-MM-DD')}</Description> 
<Description term="Mileage">{transportTruck.mileage}</Description> 
<Description term="Body Color">{transportTruck.bodyColor}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = transportTruck => {
  const {TransportTruckBase} = GlobalComponents
  return <PermissionSetting targetObject={transportTruck}  targetObjectMeta={TransportTruckBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class TransportTruckPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  transportTruck = this.props.transportTruck;
    const { id,displayName, transportTaskCount } = transportTruck
    const cardsData = {cardsName:"Transport Truck",cardsFor: "transportTruck",cardsSource: transportTruck,
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
  transportTruck: state._transportTruck,
}))(Form.create()(TransportTruckPermission))

