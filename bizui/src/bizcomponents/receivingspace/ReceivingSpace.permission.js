

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
import styles from './ReceivingSpace.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (receivingSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{receivingSpace.id}</Description> 
<Description term="Location">{receivingSpace.location}</Description> 
<Description term="Contact Number">{receivingSpace.contactNumber}</Description> 
<Description term="Description">{receivingSpace.description}</Description> 
<Description term="Total Area">{receivingSpace.totalArea}</Description> 
<Description term="Latitude">{receivingSpace.latitude}</Description> 
<Description term="Longitude">{receivingSpace.longitude}</Description> 
<Description term="Last Update Time">{ moment(receivingSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = receivingSpace => {
  const {ReceivingSpaceBase} = GlobalComponents
  return <PermissionSetting targetObject={receivingSpace}  targetObjectMeta={ReceivingSpaceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ReceivingSpacePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  receivingSpace = this.props.receivingSpace;
    const { id,displayName, goodsCount } = receivingSpace
    const cardsData = {cardsName:"Receiving Space",cardsFor: "receivingSpace",cardsSource: receivingSpace,
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
  receivingSpace: state._receivingSpace,
}))(Form.create()(ReceivingSpacePermission))

