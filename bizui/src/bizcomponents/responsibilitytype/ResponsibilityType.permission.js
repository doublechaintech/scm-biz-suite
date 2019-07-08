

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
import styles from './ResponsibilityType.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (responsibilityType,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{responsibilityType.id}</Description> 
<Description term="Code">{responsibilityType.code}</Description> 
<Description term="Base Description">{responsibilityType.baseDescription}</Description> 
<Description term="Detail Description">{responsibilityType.detailDescription}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = responsibilityType => {
  const {ResponsibilityTypeBase} = GlobalComponents
  return <PermissionSetting targetObject={responsibilityType}  targetObjectMeta={ResponsibilityTypeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ResponsibilityTypePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  responsibilityType = this.props.responsibilityType;
    const { id,displayName, employeeCount } = responsibilityType
    const cardsData = {cardsName:"Responsibility Type",cardsFor: "responsibilityType",cardsSource: responsibilityType,
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
  responsibilityType: state._responsibilityType,
}))(Form.create()(ResponsibilityTypePermission))

