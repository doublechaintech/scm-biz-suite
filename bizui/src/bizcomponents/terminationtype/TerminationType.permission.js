

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
import styles from './TerminationType.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (terminationType,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{terminationType.id}</Description> 
<Description term="代码">{terminationType.code}</Description> 
<Description term="基本描述">{terminationType.baseDescription}</Description> 
<Description term="详细描述">{terminationType.detailDescription}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = terminationType => {
  const {TerminationTypeBase} = GlobalComponents
  return <PermissionSetting targetObject={terminationType}  targetObjectMeta={TerminationTypeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class TerminationTypePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  terminationType = this.props.terminationType;
    const { id,displayName, terminationCount } = terminationType
    const cardsData = {cardsName:"雇佣终止类型",cardsFor: "terminationType",cardsSource: terminationType,
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
  terminationType: state._terminationType,
}))(Form.create()(TerminationTypePermission))

