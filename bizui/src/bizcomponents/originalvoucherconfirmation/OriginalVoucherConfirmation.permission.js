

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
import styles from './OriginalVoucherConfirmation.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (originalVoucherConfirmation,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{originalVoucherConfirmation.id}</Description> 
<Description term="谁">{originalVoucherConfirmation.who}</Description> 
<Description term="评论">{originalVoucherConfirmation.comments}</Description> 
<Description term="制造日期">{ moment(originalVoucherConfirmation.makeDate).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = originalVoucherConfirmation => {
  const {OriginalVoucherConfirmationBase} = GlobalComponents
  return <PermissionSetting targetObject={originalVoucherConfirmation}  targetObjectMeta={OriginalVoucherConfirmationBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class OriginalVoucherConfirmationPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  originalVoucherConfirmation = this.props.originalVoucherConfirmation;
    const { id,displayName, originalVoucherCount } = originalVoucherConfirmation
    const cardsData = {cardsName:"原始凭证的确认",cardsFor: "originalVoucherConfirmation",cardsSource: originalVoucherConfirmation,
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
  originalVoucherConfirmation: state._originalVoucherConfirmation,
}))(Form.create()(OriginalVoucherConfirmationPermission))

